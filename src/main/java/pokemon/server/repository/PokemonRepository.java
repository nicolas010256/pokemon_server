package pokemon.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pokemon.server.model.Pokemon;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

}