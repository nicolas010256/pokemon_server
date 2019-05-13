package pokemon.server.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pokemon.server.persistence.model.Type;


public interface TypeRepository extends JpaRepository<Type, Integer> {

}