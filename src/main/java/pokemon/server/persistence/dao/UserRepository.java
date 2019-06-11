package pokemon.server.persistence.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import pokemon.server.persistence.model.User;

public interface UserRepository extends JpaRepository<User, String> {
    
  Optional<User> findByUsernameAndPassword(String username, String password);

  Optional<User> findByUsername(String username);

  Optional<User> findByEmail(String email);

}