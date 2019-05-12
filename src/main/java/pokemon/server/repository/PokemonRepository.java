package pokemon.server.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import pokemon.server.dto.PokemonDetails;
import pokemon.server.dto.PokemonSimple;
import pokemon.server.model.Pokemon;

public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {
    
    Page<PokemonSimple> findAllByPokedexIdNotNullAndIsDefaultTrue(Pageable pageable);

    PokemonDetails findPokemonDetailsById(Integer id);
}