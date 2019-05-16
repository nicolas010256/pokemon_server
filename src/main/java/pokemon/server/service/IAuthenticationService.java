package pokemon.server.service;

import pokemon.server.exception.AuthenticationTokenException;

public interface IAuthenticationService {
    String addAuthentication(String subject) throws AuthenticationTokenException;

    String getAuthentication(String token) throws AuthenticationTokenException;
}