package pokemon.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pokemon.server.persistence.dao.TeamRepository;
import pokemon.server.persistence.model.Team;

@Service
public class TeamService implements ITeamService {
    @Autowired
    private TeamRepository repository;

    @Override
    public void save(Team team) {
        repository.save(team);
    }
}