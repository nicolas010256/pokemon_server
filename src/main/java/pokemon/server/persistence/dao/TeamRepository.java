package pokemon.server.persistence.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pokemon.server.persistence.model.Team;

public interface TeamRepository extends JpaRepository<Team, Team.Id> {

    Page<Team> findByUsername(String username, Pageable pageable);

    @Query("SELECT (COUNT(t.id.teamId) + 1) FROM Team t")
    int nextFreeId();

}