package pokemon.server.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jdk.jshell.spi.ExecutionControl.UserException;
import pokemon.server.dto.SignUpInfo;
import pokemon.server.service.IUserService;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService service;

    @PostMapping("")
    public void registerNewUser(@RequestBody SignUpInfo info) throws UserException {
        service.registerNewUserAccount(info);
    }

}