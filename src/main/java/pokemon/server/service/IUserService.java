package pokemon.server.service;

import pokemon.server.persistence.model.User;

public interface IUserService {

    void save(User user);

    User findByUsername(String username);

    Boolean verifyUser(String username, String password);
}