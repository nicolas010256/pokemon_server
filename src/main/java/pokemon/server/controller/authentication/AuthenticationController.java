package pokemon.server.controller.authentication;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pokemon.server.dto.AccountCredentials;
import pokemon.server.exception.AuthenticationTokenException;
import pokemon.server.exception.ResourceNotFoundException;
import pokemon.server.persistence.model.User;
import pokemon.server.service.AuthenticationService;
import pokemon.server.service.UserService;

// Define a classe como um controlador REST
@RestController
// Define a rota base para a classe
@RequestMapping("/auth")
public class AuthenticationController {
  
  // Define que o spring faça o gerenciamento (Dependency Injection) do atributo
  @Autowired
  // Serviço de autenticação
  private AuthenticationService authService;
  
  // Define que o spring faça o gerenciamento (Dependency Injection) do atributo
  @Autowired
  // Serviço de usuário
  private UserService userService;
  
  // Habilita Cross-Origin Resource Sharing para o método
  @CrossOrigin 
  // Mapeia uma requisição POST para o método, na rota /auth
  @PostMapping
  // @RequestBody - indidca que a informação virá no corpo (body) da requisição
  // AccountCredentials - DTO com as informações de autenticação do usuário
  // HttpServletResponse - resposta da resquisição
  public void authenticate(@RequestBody AccountCredentials credentials, HttpServletResponse res) {
    String username = credentials.getUsername();
    String password = credentials.getPassword();
    
    try {
      User user = userService.findByUsernameAndPassword(username, password);
      // Cria o token de autenticação
      String token = authService.addAuthentication(user.getUsername());
      // Passa o token para o header Authorization
      res.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + token);
      // Define que o client tem acesso ao header Authorization
      res.setHeader(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, HttpHeaders.AUTHORIZATION);
    } catch (ResourceNotFoundException e) {
      throw new AuthenticationTokenException("Unauthorized");
    }     
  } 
}