package pokemon.server.service;

import org.springframework.data.domain.Page;

import pokemon.server.persistence.model.Item;

public interface IItemService {
    
    Page<Item> findAll(int page, int size);

    Item findById(Integer id);
}