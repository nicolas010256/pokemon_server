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
import pokemon.server.persistence.model.User;
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

        User user = new User();
        user.setUsername(info.getUsername());
        user.setEmail(info.getEmail());
        user.setPassword(info.getPassword());
        user.setEnabled(true);

        service.save(user);

        try {
            String token = authService.addAuthentication(info.getUsername());
            res.setHeader("Authorization", "Bearer " + token);
            res.setHeader("Access-Control-Expose-Headers", "Authorization");
        } catch (AuthenticationTokenException e) {
            e.printStackTrace();
        }
    }

}