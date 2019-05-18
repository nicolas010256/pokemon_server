package pokemon.server.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pokemon.server.dto.SignUpInfo;
import pokemon.server.service.IAuthenticationService;
import pokemon.server.service.IUserService;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService service;

    @Autowired
    private IAuthenticationService authService;

    @PostMapping("")
    public void registerNewUser(@RequestBody SignUpInfo info) {
        
        service.registerNewUserAccount(info);        
    }

    @PostMapping("/team")
    public void createTeam() {

    }

    @GetMapping("/team")
    public String listTeams(HttpServletRequest request) {
        String username = authService.getAuthentication(request);
        return "OkayChamp " + username; 
    }

    @GetMapping("/team/{id}")
    public void getTeamById() {

    }

}