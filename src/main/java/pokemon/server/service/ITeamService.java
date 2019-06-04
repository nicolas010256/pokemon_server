package pokemon.server.service;

import org.springframework.data.domain.Page;

import pokemon.server.persistence.model.Team;

public interface ITeamService {
    void save(Team team);

    Page<Team> findByUsername(String username, int page, int size);

    Team findById(Team.Id id);

    void delete(Team.Id id);

    void delete(Team team);

    int nextFreeId(String username);
}