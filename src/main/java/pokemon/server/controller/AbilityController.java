package pokemon.server.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import pokemon.server.model.Ability;
import pokemon.server.repository.AbilityRepository;

@RestController
@CrossOrigin
public class AbilityController {

    @Autowired
    private AbilityRepository abilityRepository;

    @GetMapping("/ability/{id}")
    public Optional<Ability> getAbility(@PathVariable("id") int id) {
        return abilityRepository.findById(id);
    }
}