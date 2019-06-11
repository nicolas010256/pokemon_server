package pokemon.server.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import pokemon.server.exception.ResourceNotFoundException;
import pokemon.server.persistence.dao.ItemRepository;
import pokemon.server.persistence.model.Item;

@Service
public class ItemService implements IItemService {

    @Autowired
    private ItemRepository repository;

    @Override
    public Page<Item> findAll(int page, int size) throws ResourceNotFoundException {
        Page<Item> p = repository.findAll(PageRequest.of(page, size));
        if (p.hasContent()) {
            return repository.findAll(PageRequest.of(page, size)); 
        }

        throw new ResourceNotFoundException("Item Not Found!");
    }

    @Override
    public Item findById(Integer id) throws ResourceNotFoundException {
        Optional<Item> item = repository.findById(id);
        if (item.isPresent()) {
            return item.get();
        }
        
        throw new ResourceNotFoundException("Item Not Found!");
    }

}