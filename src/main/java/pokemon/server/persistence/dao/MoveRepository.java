package pokemon.server.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pokemon.server.persistence.model.Move;


public interface MoveRepository extends JpaRepository<Move, Integer> {

}