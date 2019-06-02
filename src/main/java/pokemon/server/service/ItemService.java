package pokemon.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import pokemon.server.persistence.dao.ItemRepository;
import pokemon.server.persistence.model.Item;

@Service
public class ItemService implements IItemService {

    @Autowired
    private ItemRepository repository;

    @Override
    public Page<Item> findAll(int page, int size) {
        return repository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Item findById(Integer id) {
        return repository.findById(id).get();
    }

}