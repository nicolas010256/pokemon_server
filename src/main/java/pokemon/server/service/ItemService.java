package pokemon.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pokemon.server.persistence.dao.ItemRepository;
import pokemon.server.persistence.model.Item;

@Service
public class ItemService implements IItemService {

    @Autowired
    private ItemRepository repository;

    @Override
    public List<Item> findAll() {
        return repository.findAll();
    }

    @Override
    public Item findById(Integer id) {
        return repository.findById(id).get();
    }

}