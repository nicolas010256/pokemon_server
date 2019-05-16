package pokemon.server.service;

import java.io.UnsupportedEncodingException;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
  private final String SECRET = "blabla";
  public String addAuthentication(String username) throws IllegalArgumentException, UnsupportedEncodingException {
      Algorithm algorithm = Algorithm.HMAC256(SECRET);
      String token = JWT.create().withSubject(username).sign(algorithm);
    return token;
  }

}