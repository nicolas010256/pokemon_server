package pokemon.server.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import pokemon.server.persistence.model.Pokemon;

public interface PokemonRepository extends JpaRepository<Pokemon, Pokemon.Id> {

    @Procedure(procedureName = "POKEMON_FREE_ID")
    // @Query(
    //     value = "SELECT case when MAX(ID) is NULL then 1 else MAX(ID) + 1 END FROM POKEMON WHERE USERNAME = :username AND TEAM_ID = :team_id",
    //     nativeQuery = true
    // )
    int nextFreeId(
        @Param("username") String username, 
        @Param("team_id") int id);

}