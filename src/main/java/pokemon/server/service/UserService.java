package pokemon.server.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import pokemon.server.exception.ResourceNotFoundException;
import pokemon.server.persistence.dao.UserRepository;
import pokemon.server.persistence.model.User;

@Service
public class UserService implements IUserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository repository;

    @Override
    public User findByUsername(String username) throws ResourceNotFoundException {
        Optional<User> user = repository.findByUsername(username);
        if (user.isPresent()){
            return user.get();
        }
        
        throw new ResourceNotFoundException("User Not Found!");
    }

    @Override
	public User findByUsernameAndPassword(String username, String password) {
        User user = findByUsername(username);
        if (passwordEncoder.matches(password, user.getPassword())) {
            return user;
        }

        throw new ResourceNotFoundException("User Not Found!");
    }

    @Override
    public void save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repository.save(user);
    }

}