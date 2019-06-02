package pokemon.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import pokemon.server.persistence.dao.WildPokemonRepository;
import pokemon.server.persistence.model.WildPokemon;

@Service
public class WildPokemonService implements IWildPokemonService {

    @Autowired
    private WildPokemonRepository repository;

    @Override
    public Page<WildPokemon> findAllDefault(int page, int size) {        
        return repository.findAllByPokedexIdNotNullAndIsDefaultTrue(PageRequest.of(page, size));
    }

    @Override
    public WildPokemon findById(Integer id) {
        return repository.findById(id).get();
    }
}