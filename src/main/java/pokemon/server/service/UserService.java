package pokemon.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import pokemon.server.persistence.dao.UserRepository;
import pokemon.server.persistence.model.User;

@Service
public class UserService implements IUserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository repository;

    @Override
    public User findByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
	public Boolean verifyUser(String username, String password) {
        User user = repository.findById(username).get();
        if (user != null) {
            return passwordEncoder.matches(password, user.getPassword());
        } else {
            return false;
        }
    }

    @Override
    public void save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repository.save(user);
    }

}