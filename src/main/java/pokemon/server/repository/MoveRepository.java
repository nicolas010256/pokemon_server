package pokemon.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pokemon.server.model.Move;

public interface MoveRepository extends JpaRepository<Move, Integer> {

}