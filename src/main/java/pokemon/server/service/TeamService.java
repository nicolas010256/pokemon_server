package pokemon.server.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

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
    public Page<Team> findByUsername(String username, int page, int size) {
        return repository.findByUsername(username, PageRequest.of(page, size));
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
}