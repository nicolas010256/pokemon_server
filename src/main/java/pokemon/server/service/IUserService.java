package pokemon.server.service;

import pokemon.server.dto.AccountCredentials;
import pokemon.server.dto.SignUpInfo;
import pokemon.server.persistence.model.User;

public interface IUserService {

    User registerNewUserAccount(SignUpInfo info);

    Boolean verifyUser(AccountCredentials credentials);
}