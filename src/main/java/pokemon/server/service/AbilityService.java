package pokemon.server.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import pokemon.server.exception.ResourceNotFoundException;
import pokemon.server.persistence.dao.AbilityRepository;
import pokemon.server.persistence.model.Ability;

@Service
public class AbilityService implements IAbilityService {
    
    @Autowired
    private AbilityRepository repository;

    @Override
    public Page<Ability> findAll(int page, int size) throws ResourceNotFoundException {
        Page<Ability> p = repository.findAll(PageRequest.of(page, size));
        if (p.hasContent()) {      
            return repository.findAll(PageRequest.of(page, size)); 
        }
        throw new ResourceNotFoundException("Ability Not Found!");
    }
    
    @Override
    public Ability findById(Integer id) throws ResourceNotFoundException {
        Optional<Ability> ability = repository.findById(id);
        if (ability.isPresent()) {
            return ability.get();
        }
        throw new ResourceNotFoundException("Ability Not Found!");
    }

}