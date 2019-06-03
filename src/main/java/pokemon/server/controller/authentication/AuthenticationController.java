package pokemon.server.controller.authentication;

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

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

  @Autowired
  private AuthenticationService authService;

  @Autowired
  private UserService userService;

  @CrossOrigin
  @PostMapping()
  public void authenticate(@RequestBody AccountCredentials credentials, HttpServletResponse res) {

    if (userService.verifyUser(credentials.getUsername(), credentials.getPassword())) {
      try {
        String token = authService.addAuthentication(credentials.getUsername());
        res.setHeader("Authorization", "Bearer " + token);
        res.setHeader("Access-Control-Expose-Headers", "Authorization");
      } catch (AuthenticationTokenException e) {
        e.printStackTrace();
      }
    } 
  }
}