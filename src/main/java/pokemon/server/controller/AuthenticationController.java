package pokemon.server.controller;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pokemon.server.persistence.dao.UserRepository;
import pokemon.server.persistence.model.User;
import pokemon.server.service.AuthenticationService;

@CrossOrigin
@RestController
@RequestMapping("/authentication")
public class AuthenticationController {

  @Autowired
  private AuthenticationService service;

  @Autowired
  private UserRepository repository;

  @PostMapping("")
  public String authenticate(@RequestParam("username") String username, @RequestParam("password") String password) {

    User user = repository.findByUsernameAndPassword(username, password);
    if (user != null) {
      try {
        return service.addAuthentication(username);
      } catch (IllegalArgumentException | UnsupportedEncodingException e) {
        e.printStackTrace();
      }
    }

    return "Se fudeu";
  } 


}