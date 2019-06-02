package pokemon.server.service;

import pokemon.server.dto.PokemonInfo;
import pokemon.server.persistence.model.Pokemon;

public interface IPokemonService {
    
    void save(Pokemon pokemon);

    int nextFreeId(String username, int teamId);

    PokemonInfo findInfoById(Pokemon.Id id);
}