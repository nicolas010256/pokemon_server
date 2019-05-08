package pokemon.server.repository;


import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import pokemon.server.model.Pokemon;

public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {
    List<Pokemon> findAllByPokedexIdNotNullAndIsDefaultTrue(Pageable pageable);
}