package pokemon.server.service;

import pokemon.server.dto.AccountCredentials;
import pokemon.server.dto.SignUpInfo;
import pokemon.server.exception.UserException;
import pokemon.server.persistence.model.User;

public interface IUserService {

    User registerNewUserAccount(SignUpInfo info) throws UserException;

    User findByUsername(String username);

    Boolean verifyUser(AccountCredentials credentials);
}