package pokemon.server.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pokemon.server.persistence.model.Ability;


public interface AbilityRepository extends JpaRepository<Ability, Integer> {
    
}