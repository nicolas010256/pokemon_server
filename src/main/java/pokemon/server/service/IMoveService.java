package pokemon.server.service;

import pokemon.server.exception.ResourceNotFoundException;
import pokemon.server.persistence.model.Move;

public interface IMoveService {
    Move findById(Integer id) throws ResourceNotFoundException;
}