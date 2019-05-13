package pokemon.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pokemon.server.persistence.dao.AbilityRepository;
import pokemon.server.persistence.model.Ability;

@Service
public class AbilityService implements IAbilityService {
    
    @Autowired
    private AbilityRepository repository;

    @Override
    public Ability findById(Integer id) {
        return repository.findById(id).get();
    }

}