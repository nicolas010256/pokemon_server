package pokemon.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pokemon.server.persistence.model.Ability;
import pokemon.server.service.IAbilityService;

@CrossOrigin
@RestController
@RequestMapping("/ability")
public class AbilityController {

    @Autowired
    private IAbilityService service;

    @GetMapping("")
    public void index() {
        
    }


    @GetMapping("/{id}")
    public Ability getAbility(@PathVariable("id") int id) {
        return service.findById(id);
    }
}