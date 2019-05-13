package pokemon.server.service;

import pokemon.server.persistence.model.Type;

public interface ITypeService {
    Type findById(Integer id);
}