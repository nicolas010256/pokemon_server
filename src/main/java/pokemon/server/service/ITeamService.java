package pokemon.server.service;

import org.springframework.data.domain.Page;

import pokemon.server.exception.ResourceNotFoundException;
import pokemon.server.persistence.model.Team;

public interface ITeamService {
    void save(Team team);

    Page<Team> findByUsername(String username, int page, int size) throws ResourceNotFoundException;

    Team findById(Team.Id id) throws ResourceNotFoundException;

    void delete(Team.Id id) throws ResourceNotFoundException;

    int nextFreeId(String username);

    void update(Team team) throws ResourceNotFoundException;
}