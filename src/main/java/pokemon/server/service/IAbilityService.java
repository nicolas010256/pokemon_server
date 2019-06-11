package pokemon.server.service;

import org.springframework.data.domain.Page;

import pokemon.server.exception.ResourceNotFoundException;
import pokemon.server.persistence.model.Ability;

public interface IAbilityService {

    Page<Ability> findAll(int page, int size) throws ResourceNotFoundException;

    Ability findById(Integer id) throws ResourceNotFoundException;
}