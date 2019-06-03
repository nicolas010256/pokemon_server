package pokemon.server.persistence.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import pokemon.server.persistence.model.Team;

public interface TeamRepository extends JpaRepository<Team, Team.Id> {

    @Query("SELECT t FROM Team t where t.id.username = :username")
    Page<Team> findByUsername(@Param("username") String username, Pageable pageable);


    // @Query("SELECT (COUNT(t.id.teamId) + 1) FROM Team t")
    @Procedure(procedureName = "TEAM_FREE_ID")
    int nextFreeId(String username);

}