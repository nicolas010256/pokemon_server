package pokemon.server.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pokemon.server.model.Type;
import pokemon.server.repository.TypeRepository;

@RestController
@RequestMapping("/type")
public class TypeController {

    @Autowired
    private TypeRepository typeRepository;

    @GetMapping({ "/", "" })
    public List<Type> getTypes() {
        return typeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Type> getType(@PathVariable("id") Integer id) {
        return typeRepository.findById(id);
    }
}