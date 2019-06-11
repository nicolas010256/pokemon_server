package pokemon.server.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pokemon.server.exception.ResourceNotFoundException;
import pokemon.server.persistence.dao.TypeRepository;
import pokemon.server.persistence.model.Type;

@Service
public class TypeService implements ITypeService {

    @Autowired
    private TypeRepository repository;

    @Override
    public Type findById(Integer id) throws ResourceNotFoundException {
        Optional<Type> type = repository.findById(id);
        if (type.isPresent()) {
            return type.get();
        }

        throw new ResourceNotFoundException("Type Not Found!");
    }

}