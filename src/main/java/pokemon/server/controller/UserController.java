package pokemon.server.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jdk.jshell.spi.ExecutionControl.UserException;
import pokemon.server.dto.SignUpInfo;
import pokemon.server.dto.TeamInfo;
import pokemon.server.persistence.model.Team;
import pokemon.server.persistence.model.User;
import pokemon.server.service.IAuthenticationService;
import pokemon.server.service.ITeamService;
import pokemon.server.service.IUserService;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService service;

    @Autowired
    private ITeamService teamService;

    @Autowired
    private IAuthenticationService authService;

    @PostMapping("")
    public void registerNewUser(@RequestBody SignUpInfo info) throws UserException {
        service.registerNewUserAccount(info);
    }

    @PostMapping("/team")
    public void createTeam(@RequestBody TeamInfo info, HttpServletRequest req) {
        String username = authService.getAuthentication(req);
        if (!"".equals(username) && username != null) {
            Team team = new Team();
            team.setId(new Team.Id(1, username));
            team.setName(info.getName());
            teamService.save(team);
        }
    }

    @GetMapping("/team")
    public List<Team> listTeams(HttpServletRequest req) {
        String username = authService.getAuthentication(req);
        User user = service.findByUsername(username);
        return user.getTeams();
    }

    @GetMapping("/team/{id}")
    public void getTeamById() {

    }

}