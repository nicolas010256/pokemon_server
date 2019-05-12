package pokemon.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pokemon.server.model.Ability;

public interface AbilityRepository extends JpaRepository<Ability, Integer> {
    
}