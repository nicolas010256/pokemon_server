package pokemon.server.service;

import pokemon.server.persistence.model.Move;

public interface IMoveService {
    Move findById(Integer id);
}