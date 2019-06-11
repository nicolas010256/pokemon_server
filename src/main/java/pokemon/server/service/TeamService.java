package pokemon.server.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import pokemon.server.exception.ResourceNotFoundException;
import pokemon.server.persistence.dao.TeamRepository;
import pokemon.server.persistence.model.Team;
import pokemon.server.persistence.model.Team.Id;

@Service
public class TeamService implements ITeamService {

    @Autowired
    private TeamRepository repository;

    // @Autowired
    // private IPokemonService pService;

    @Override
    public void save(Team team) {
        repository.save(team);
    }

    @Override
    public Page<Team> findByUsername(String username, int page, int size) throws ResourceNotFoundException {
        Page<Team> p = repository.findByUsername(username, PageRequest.of(page, size));
        if (p.hasContent()) {
            return p;
        }
        
        throw new ResourceNotFoundException("Team Not Found!");
    }

    @Override
    public Team findById(Id id) throws ResourceNotFoundException {
        Optional<Team> team = repository.findById(id);
        if (team.isPresent()) {
            return team.get();
        }
        
        throw new ResourceNotFoundException("Team Not Found!");
    }

    @Override
    public void delete(Id id) throws ResourceNotFoundException {
        Team team = findById(id);
        repository.delete(team);
    }

    @Override
    public int nextFreeId(String username) {
        return repository.nextFreeId(username);
    }

    @Override
    public void update(Team team) throws ResourceNotFoundException {
        Optional<Team> t = repository.findById(team.getId());
        if (t.isPresent()) {
            repository.save(team);
        } else {
            throw new ResourceNotFoundException("Team Not Found!");
        }
    } 

    // @Override
    // public void delete(Team team) {
    //     team.getPokemon().forEach(pokemon -> {
    //         pService.delete(pokemon.getId());
    //     });
    //     repository.delete(team);
    // }
}