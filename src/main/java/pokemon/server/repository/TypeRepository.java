package pokemon.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pokemon.server.model.Type;

public interface TypeRepository extends JpaRepository<Type, Long> {

}