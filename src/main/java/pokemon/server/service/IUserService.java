package pokemon.server.service;

import pokemon.server.dto.AccountCredentials;
import pokemon.server.persistence.model.User;

public interface IUserService {

    User registerNewUserAccount(AccountCredentials credentials);
}