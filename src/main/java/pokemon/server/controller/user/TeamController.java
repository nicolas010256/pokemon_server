package pokemon.server.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pokemon.server.dto.TeamInfo;
import pokemon.server.persistence.model.Team;
import pokemon.server.service.ITeamService;

@CrossOrigin
@RestController
@RequestMapping("/user/team")
public class TeamController {

    @Autowired
    private ITeamService service;
    
    @CrossOrigin
    @PostMapping()
    public void createTeam(@RequestAttribute("username") String username, @RequestBody TeamInfo info) {
        Team team = new Team();
        Team.Id id = new Team.Id(service.nextFreeId(), username);
        team.setId(id);
        team.setName(info.getName());
        service.save(team);
    }

    @GetMapping()
    public List<TeamInfo> getAllTeams(@RequestAttribute("username") String username) {
        return service.findByUsername(username);
    }

    @GetMapping("/{id}")
    public TeamInfo getTeam(@RequestAttribute("username") String username, @PathVariable("id") int id) {
        return service.findInfoById(new Team.Id(id, username));
    }

    @PutMapping("/{id}")
    public void updateTeam(@RequestAttribute("username") String username, @PathVariable("id") int teamId,
             @RequestBody TeamInfo info) {

        Team team = new Team();
        Team.Id id = new Team.Id(teamId, username);
        team.setId(id);
        team.setName(info.getName());
        service.save(team);
    }

    @DeleteMapping("/{id}")
    public void deleteTeam(@RequestAttribute("username") String username, @PathVariable("id") int id) {
        service.delete(new Team.Id(id, username));
    }
}