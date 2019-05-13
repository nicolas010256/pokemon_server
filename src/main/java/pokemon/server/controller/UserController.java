package pokemon.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pokemon.server.dto.AccountCredentials;
import pokemon.server.service.IUserService;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService service;

    @PostMapping("")
    
    public void registerNewUser(@RequestBody @RequestParam("username") String username,
            @RequestBody @RequestParam("password") String password,
            @RequestBody @RequestParam("email") String email) {
        
        AccountCredentials credentials = new AccountCredentials(username, password, email);
        
        service.registerNewUserAccount(credentials);        
    }
}