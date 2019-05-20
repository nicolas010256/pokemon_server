package pokemon.server.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pokemon.server.persistence.model.Nature;

public interface NatureRepository extends JpaRepository<Nature, Integer> {
    
}