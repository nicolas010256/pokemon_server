package pokemon.server.controller.pokedex;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pokemon.server.persistence.model.Item;
import pokemon.server.service.IItemService;

@CrossOrigin
@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private IItemService service;
    
    @GetMapping("")
    public List<Item> getAllItems() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Item getItemById(@PathVariable("id") int id) {
        return service.findById(id);
    }
}