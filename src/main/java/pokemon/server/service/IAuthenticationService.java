package pokemon.server.service;

import javax.servlet.http.HttpServletRequest;

import pokemon.server.exception.AuthenticationTokenException;

public interface IAuthenticationService {
    String addAuthentication(String subject) throws AuthenticationTokenException;

    String getAuthentication(HttpServletRequest request) throws AuthenticationTokenException;
}