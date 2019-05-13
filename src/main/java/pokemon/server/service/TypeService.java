package pokemon.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pokemon.server.persistence.dao.TypeRepository;
import pokemon.server.persistence.model.Type;

@Service
public class TypeService implements ITypeService {

    @Autowired
    private TypeRepository repository;

    @Override
    public Type findById(Integer id) {
        return repository.findById(id).get();
    }

}