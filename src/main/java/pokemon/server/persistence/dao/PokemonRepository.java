package pokemon.server.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import pokemon.server.persistence.model.Pokemon;

public interface PokemonRepository extends JpaRepository<Pokemon, Pokemon.Id> {

    // @Query("SELECT (COUNT(p.id.teamPokemonId) + 1) FROM Pokemon p where p.id.username = :username AND p.id.teamId = :teamId")
    @Procedure(procedureName = "POKEMON_FREE_ID")
    int nextFreeId(@Param("USERNAME_IN") String username, @Param("TEAM_ID_IN") int id);

}