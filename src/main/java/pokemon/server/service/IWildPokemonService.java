package pokemon.server.service;

import org.springframework.data.domain.Page;

import pokemon.server.persistence.model.WildPokemon;

public interface IWildPokemonService {

    Page<WildPokemon> findAllDefault(int page, int size);
    
    WildPokemon findById(Integer id);
}