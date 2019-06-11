package pokemon.server.service;

import pokemon.server.exception.ResourceNotFoundException;
import pokemon.server.persistence.model.Type;

public interface ITypeService {
    Type findById(Integer id) throws ResourceNotFoundException;
}