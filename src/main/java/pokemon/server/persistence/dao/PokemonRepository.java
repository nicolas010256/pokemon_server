package pokemon.server.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pokemon.server.persistence.model.Pokemon;

public interface PokemonRepository extends JpaRepository<Pokemon, Pokemon.Id> {

    // @Query("SELECT  case when (max(p.id.teamPokemonId) + 1) IS NULL THEN 1 ELSE max(p.id.teamPokemonId) + 1) END FROM Pokemon p where p.id.username = :username AND p.id.teamId = :teamId")
    // @Procedure(procedureName = "POKEMON_FREE_ID")
    @Query(
        value = "SELECT case when MAX(ID) is NULL then 1 else MAX(ID) + 1 END FROM POKEMON WHERE USERNAME = :username AND TEAM_ID = :teamId",
        nativeQuery = true
    )
    int nextFreeId(
        @Param("username") String username, 
        @Param("teamId") int id);

}