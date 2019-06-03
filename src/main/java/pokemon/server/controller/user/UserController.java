package pokemon.server.controller.user;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pokemon.server.dto.SignUpInfo;
import pokemon.server.exception.AuthenticationTokenException;
import pokemon.server.service.AuthenticationService;
import pokemon.server.service.IUserService;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private AuthenticationService authService;

    @Autowired
    private IUserService service;

    @PostMapping
    public void createUser(@RequestBody SignUpInfo info, HttpServletResponse res) {
        service.registerNewUserAccount(info);
        try {
            String token = authService.addAuthentication(info.getUsername());
            res.setHeader("Authorization", "Bearer " + token);
            res.setHeader("Access-Control-Expose-Headers", "Authorization");
        } catch (AuthenticationTokenException e) {
            e.printStackTrace();
        }
    }

}