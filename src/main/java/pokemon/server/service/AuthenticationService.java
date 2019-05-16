package pokemon.server.service;

import java.io.UnsupportedEncodingException;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import org.springframework.stereotype.Service;

import pokemon.server.exception.AuthenticationTokenException;

@Service
public class AuthenticationService implements IAuthenticationService {
  private final String SECRET = "blabla";
  private final String ISSUER = "PKMS";

  public String addAuthentication(String username) throws AuthenticationTokenException {
    try {
      Algorithm algorithm = Algorithm.HMAC256(SECRET);
      String token = JWT.create()
          .withSubject(username)
          .withIssuer(ISSUER)
          .sign(algorithm);
      return token;
    } catch (IllegalArgumentException | UnsupportedEncodingException | JWTCreationException e) {
      throw new AuthenticationTokenException("Could not generate Json Web Token.");
    }

  }

  @Override
  public String getAuthentication(String token) throws AuthenticationTokenException {
    try {
      Algorithm algorithm = Algorithm.HMAC512(SECRET);
      JWTVerifier verifier = JWT.require(algorithm)
        .withIssuer(ISSUER)
        .build();
      DecodedJWT jwt = verifier.verify(token);
      String subject = jwt.getSubject();
      return subject;
    } catch (IllegalArgumentException | UnsupportedEncodingException | JWTVerificationException e) {
      throw new AuthenticationTokenException("Could not decode Json Web Token.");
    }
  }

}