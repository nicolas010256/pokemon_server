package pokemon.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import pokemon.server.dto.AccountCredentials;
import pokemon.server.dto.SignUpInfo;
import pokemon.server.exception.UserException;
import pokemon.server.persistence.dao.UserRepository;
import pokemon.server.persistence.model.User;

@Service
public class UserService implements IUserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository repository;

    @Override
    public User registerNewUserAccount(SignUpInfo info) throws UserException {

        if (usernameExists(info.getUsername()))
            throw new UserException("Username already taken.");
        if (emailExists(info.getEmail()))
            throw new UserException("Email already in use.");

        User user = new User();
        user.setUsername(info.getUsername());
        user.setPassword(passwordEncoder.encode(info.getPassword()));
        user.setEmail(info.getEmail());
        user.setEnabled(true);

        return repository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
	public Boolean verifyUser(AccountCredentials credentials) {
        User user = repository.findById(credentials.getUsername()).get();
        if (user != null) {
            return passwordEncoder.matches(credentials.getPassword(), user.getPassword());
        } else {
            return false;
        }
    }
    
    private boolean emailExists(String email) {
        return repository.findByEmail(email) != null;
    }

    private boolean usernameExists(String username) {

        return repository.findByUsername(username) != null;
    }

}