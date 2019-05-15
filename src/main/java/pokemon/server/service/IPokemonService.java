package pokemon.server.service;

import org.springframework.data.domain.Pageable;
import org.springframework.web.util.UriComponentsBuilder;

import pokemon.server.dto.CustomPage;
import pokemon.server.dto.PokemonDetails;

public interface IPokemonService {
    CustomPage findAllPokemonPagination(Pageable pageable, UriComponentsBuilder uriBuilder);
    
    PokemonDetails findPokemonById(Integer id);
}