package pokemon.server.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pokemon.server.persistence.model.TeamPokemon;

public interface TeamPokemonRepository extends JpaRepository<TeamPokemon, TeamPokemon.Id> {

    @Query("SELECT (COUNT(p.id.teamPokemonId) + 1) FROM TeamPokemon p where p.id.username = :username AND p.id.teamId = :teamId")
    int nextFreeId(@Param("username") String username, @Param("teamId") int teamId);

}