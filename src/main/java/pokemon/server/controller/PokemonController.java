package pokemon.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import pokemon.server.dto.PageDTO;
import pokemon.server.dto.PokemonDetails;
import pokemon.server.dto.PokemonSimple;
import pokemon.server.repository.PokemonRepository;

@RestController
public class PokemonController {
    @Autowired
    private PokemonRepository pokemonRepository;

    @CrossOrigin
    @GetMapping("/pokemon")
    public PageDTO getPokemon(
       @RequestParam(value = "limit", defaultValue = "20") int size,
       @RequestParam(value = "page", defaultValue = "1") int page,
       UriComponentsBuilder uriBuilder) {
        
        if(page < 1)
            page = 1;
        page--;

        Page<PokemonSimple> p = pokemonRepository.findAllByPokedexIdNotNullAndIsDefaultTrue(PageRequest.of(page, size));
        PageDTO resultPage = new PageDTO();
        resultPage.setContent(p.getContent());
        if (page > 0) {
            String prev = uriBuilder.replaceQueryParam("page", page).replaceQueryParam("limit", size).build().encode().toString();
            resultPage.setPrev(prev);
        }
        if (page < p.getTotalPages() - 1) {
            String next = uriBuilder.replaceQueryParam("page", page + 2).replaceQueryParam("limit", size).build().encode().toString();
            resultPage.setNext(next);
        }
        return resultPage;
    }

    @CrossOrigin
    @GetMapping("/pokemon/{id}")
    public PokemonDetails getPokemon(@PathVariable("id") int id) {

        return pokemonRepository.findPokemonDetailsById(id);
    }
}