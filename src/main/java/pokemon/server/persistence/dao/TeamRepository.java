package pokemon.server.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pokemon.server.persistence.model.Team;

public interface TeamRepository extends JpaRepository<Team, Team.Id> {

}