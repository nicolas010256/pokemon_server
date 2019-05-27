package pokemon.server.service;

import pokemon.server.dto.PokemonInfo;
import pokemon.server.persistence.model.TeamPokemon;

public interface ITeamPokemonService {
    
    void save(TeamPokemon pokemon);

    int nextFreeId(String username, int teamId);

    PokemonInfo findInfoById(TeamPokemon.Id id);
}