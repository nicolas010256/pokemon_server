package pokemon.server.persistence.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pokemon.server.persistence.model.Team;

public interface TeamRepository extends JpaRepository<Team, Team.Id> {

    @Query("SELECT t FROM Team t where t.id.username = :username")
    Page<Team> findByUsername(@Param("username") String username, Pageable pageable);


    // @Query("SELECT CASE WHEN (MAX(t.id.teamId) + 1) IS NULL THEN 1 ELSE (MAX(t.id.teamId) + 1) END FROM Team t WHERE t.id.username = :username")
    // @Procedure(procedureName = "TEAM_FREE_ID")
    @Query(
        value = "SELECT case when MAX(ID) is NULL THEN 1 else MAX(ID) + 1 END FROM TEAM WHERE USERNAME = :username",
        nativeQuery = true
    )
    int nextFreeId(@Param("username") String username);

}