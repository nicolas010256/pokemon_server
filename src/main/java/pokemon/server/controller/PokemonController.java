package pokemon.server.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pokemon.server.model.Pokemon;
import pokemon.server.repository.PokemonRepository;

@RestController
public class PokemonController {
    @Autowired
    private PokemonRepository pokemonRepository;

    @CrossOrigin
    @GetMapping("/pokemon")
    public Iterable<Pokemon> getPokemon(
                    @RequestParam(value = "limit", defaultValue = "20") int limit,
                    @RequestParam(value = "page", defaultValue = "1") int page) {
        
        if(page < 1)
            page = 1;
        page--;
        return pokemonRepository.findAllByPokedexIdNotNullAndIsDefaultTrue(PageRequest.of(page, limit));
    }

    @CrossOrigin
    @GetMapping("/pokemon/{id}")
    public Optional<Pokemon> getPokemon(@PathVariable("id") int id) {

        return pokemonRepository.findById(id);
    }
}