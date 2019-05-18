package pokemon.server.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pokemon.server.dto.AccountCredentials;
import pokemon.server.exception.AuthenticationTokenException;
import pokemon.server.service.AuthenticationService;
import pokemon.server.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/auth")
public class AuthenticationController {

  @Autowired
  private AuthenticationService authService;

  @Autowired
  private UserService userService;

  @PostMapping("")
  public void authenticate(@RequestBody AccountCredentials credentials, HttpServletResponse res) {

    if (userService.verifyUser(credentials)) {
      try {
        String token = authService.addAuthentication(credentials.getUsername());
        res.setHeader("Authorization", "Bearer " + token);
      } catch (AuthenticationTokenException e) {
        e.printStackTrace();
      }
    } 
  }
}