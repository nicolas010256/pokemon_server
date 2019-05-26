package pokemon.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pokemon.server.dto.TeamInfo;
import pokemon.server.persistence.dao.TeamRepository;
import pokemon.server.persistence.model.Team;
import pokemon.server.persistence.model.Team.Id;

@Service
public class TeamService implements ITeamService {

    @Autowired
    private TeamRepository repository;

    @Override
    public void save(Team team) {
        repository.save(team);
    }

    @Override
    public List<TeamInfo> findByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public Team findById(Id id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(Id id) {
        repository.deleteById(id);
    }

    @Override
    public int nextFreeId() {
        return repository.nextFreeId();
    }

    @Override
    public TeamInfo findInfoById(Id id) {
        return repository.findInfoById(id);
    }
}