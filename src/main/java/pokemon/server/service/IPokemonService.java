package pokemon.server.service;

import pokemon.server.persistence.model.Pokemon;

public interface IPokemonService {
    
    void save(Pokemon pokemon);

    int nextFreeId(String username, int teamId);

    Pokemon findById(Pokemon.Id id);

    void delete(Pokemon.Id id);
}