package pokemon.server.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pokemon.server.persistence.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {
    
}