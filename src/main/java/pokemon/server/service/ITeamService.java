package pokemon.server.service;

import pokemon.server.persistence.model.Team;

public interface ITeamService {
    void save(Team team);
}