package pokemon.server.service;

import java.util.List;

import pokemon.server.dto.TeamInfo;
import pokemon.server.persistence.model.Team;

public interface ITeamService {
    void save(Team team);

    List<TeamInfo> findByUsername(String username);

    Team findById(Team.Id id);

    TeamInfo findInfoById(Team.Id id);

    void delete(Team.Id id);

    int nextFreeId();
}