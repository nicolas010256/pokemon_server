package pokemon.server.service;

import pokemon.server.persistence.model.Ability;

public interface IAbilityService {
    Ability findById(Integer id);
}