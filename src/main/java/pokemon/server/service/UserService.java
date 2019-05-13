package pokemon.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import pokemon.server.dto.AccountCredentials;
import pokemon.server.persistence.dao.UserRepository;
import pokemon.server.persistence.model.User;

@Service
public class UserService implements IUserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository repository;

    @Override
    public User registerNewUserAccount(AccountCredentials credentials) {
        User user = new User();
        user.setUsername(credentials.getUsername());
        user.setPassword(passwordEncoder.encode(credentials.getPassword()));
        user.setEmail(credentials.getEmail());
        user.setEnabled(true);

        return repository.save(user);
    }

}