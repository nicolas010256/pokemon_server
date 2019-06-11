package pokemon.server.service;

import pokemon.server.exception.ResourceNotFoundException;
import pokemon.server.persistence.model.User;

public interface IUserService {

    void save(User user);

    User findByUsername(String username) throws ResourceNotFoundException;

    User findByUsernameAndPassword(String username, String password) throws ResourceNotFoundException;
}