package pokemon.server.service;

import java.util.List;

import pokemon.server.persistence.model.Item;

public interface IItemService {
    List<Item> findAll();

    Item findById(Integer id);
}