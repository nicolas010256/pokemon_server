package pokemon.server.service;

import pokemon.server.exception.ConflictException;
import pokemon.server.exception.ResourceNotFoundException;
import pokemon.server.persistence.model.Pokemon;

public interface IPokemonService {
    
    void save(Pokemon pokemon) throws ConflictException;

    int nextFreeId(String username, int teamId);

    Pokemon findById(Pokemon.Id id) throws ResourceNotFoundException;

    void delete(Pokemon.Id id) throws ResourceNotFoundException;

    void update(Pokemon pokemon) throws ResourceNotFoundException;
}