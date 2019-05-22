package pokemon.server.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pokemon.server.persistence.model.User;

public interface UserRepository extends JpaRepository<User, String> {
    
  User findByUsernameAndPassword(String username, String password);

  User findByUsername(String username);

  User findByEmail(String email);

}