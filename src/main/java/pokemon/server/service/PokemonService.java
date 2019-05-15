package pokemon.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import pokemon.server.dto.CustomPage;
import pokemon.server.dto.PokemonDetails;
import pokemon.server.dto.PokemonSimple;
import pokemon.server.persistence.dao.PokemonRepository;
import pokemon.server.util.PaginationUtil;

@Service
public class PokemonService implements IPokemonService {

    @Autowired
    private PokemonRepository repository;

    @Override
    public CustomPage findAllPokemonPagination(Pageable pageable, UriComponentsBuilder uriBuilder) {
        Page<PokemonSimple> page = repository.findAllByPokedexIdNotNullAndIsDefaultTrue(pageable);
        PaginationUtil paginationUtil = new PaginationUtil(page, uriBuilder);

        String prev = paginationUtil.getPrev();
        String next = paginationUtil.getNext();

        CustomPage customPage = new CustomPage(page.getContent(), prev, next);

        return customPage;
    }

    @Override
    public PokemonDetails findPokemonById(Integer id) {
        return repository.findPokemonDetailsById(id);
    }
}