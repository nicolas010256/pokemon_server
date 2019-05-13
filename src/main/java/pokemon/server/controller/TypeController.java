package pokemon.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pokemon.server.persistence.model.Type;
import pokemon.server.service.ITypeService;

@CrossOrigin
@RestController
@RequestMapping("/type")
public class TypeController {

    @Autowired
    private ITypeService service;

    @GetMapping("/{id}")
    public Type getType(@PathVariable("id") Integer id) {
        return service.findById(id);
    }
}