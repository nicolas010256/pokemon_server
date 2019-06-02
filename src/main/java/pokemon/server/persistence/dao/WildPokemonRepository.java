package pokemon.server.persistence.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import pokemon.server.persistence.model.WildPokemon;

public interface WildPokemonRepository extends JpaRepository<WildPokemon, Integer> {
    
    Page<WildPokemon> findAllByPokedexIdNotNullAndIsDefaultTrue(Pageable pageable);
}