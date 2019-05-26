package pokemon.server.persistence.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pokemon.server.dto.TeamInfo;
import pokemon.server.persistence.model.Team;

public interface TeamRepository extends JpaRepository<Team, Team.Id> {

    @Query("SELECT NEW pokemon.server.dto.TeamInfo(t.id.teamId, t.name) FROM Team t where t.id.username = :username")
    List<TeamInfo> findByUsername(@Param("username") String username);

    @Query("SELECT (COUNT(t.id.teamId) + 1) FROM Team t")
    int nextFreeId();

    @Query("SELECT NEW pokemon.server.dto.TeamInfo(t.id.teamId, t.name) FROM Team t where t.id = :id")
    TeamInfo findInfoById(@Param("id") Team.Id id);

}