package pokemon.server.controller.pokedex;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pokemon.server.persistence.model.Nature;
import pokemon.server.service.INatureService;

@CrossOrigin
@RestController
@RequestMapping("/nature")
public class NatureController {

    @Autowired
    private INatureService service;

    @GetMapping
    public List<Nature> getAllNatures() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Nature getById(@PathVariable("id") int id) {
        return service.findById(id);
    }
}