package pokemon.server.controller.pokedex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import pokemon.server.dto.CustomPage;
import pokemon.server.dto.PokemonDetails;
import pokemon.server.service.IPokemonService;

@CrossOrigin
@RestController
@RequestMapping("/pokemon")
public class WildPokemonController {
    
    @Autowired
    private IPokemonService service;
    
    @GetMapping("")
    public CustomPage getPokemon(
            @RequestParam(value = "size", defaultValue = "20") int size,
            @RequestParam(value = "page", defaultValue = "0") int page,
            UriComponentsBuilder uriBuilder) {
        
        return service.findAllPokemonPagination(PageRequest.of(page, size), uriBuilder);
    }

    @GetMapping("/{id}")
    public PokemonDetails getPokemon(@PathVariable("id") int id) {

        return service.findPokemonById(id);
    }
}