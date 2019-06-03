package pokemon.server.controller.pokedex;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import pokemon.server.dto.CustomPage;
import pokemon.server.dto.WildPokemonBrief;
import pokemon.server.dto.WildPokemonDetailed;
import pokemon.server.persistence.model.WildPokemon;
import pokemon.server.service.IWildPokemonService;
import pokemon.server.util.PaginationUtil;

@CrossOrigin
@RestController
@RequestMapping("/pokemon")
public class WildPokemonController {
    
    @Autowired
    private IWildPokemonService service;
    
    @GetMapping
    public CustomPage getPokemon(
            @RequestParam(value = "size", defaultValue = "20") int size,
            @RequestParam(value = "page", defaultValue = "0") int page,
            UriComponentsBuilder uriBuilder) {

        Page<WildPokemon> wildPokemonPage = service.findAllDefault(page, size);

        PaginationUtil paginationUtil = new PaginationUtil(wildPokemonPage, uriBuilder);

        String prev = paginationUtil.getPrev();
        String next = paginationUtil.getNext();

        List<WildPokemonBrief> content = new ArrayList<WildPokemonBrief>();

        wildPokemonPage.getContent().forEach(wildPokemon -> {
            WildPokemonBrief wildPokemonBrief = new WildPokemonBrief();
            wildPokemonBrief.setId(wildPokemon.getId());
            wildPokemonBrief.setName(wildPokemon.getName());
            wildPokemonBrief.setSprite(wildPokemon.getSprite());
            wildPokemonBrief.setPokedexId(wildPokemon.getPokedexId());
            
            List<WildPokemonBrief.Type> types = new ArrayList<WildPokemonBrief.Type>();

            wildPokemon.getTypes().forEach(type -> {
                WildPokemonBrief.Type t = new WildPokemonBrief.Type();
                t.setId(type.getId());
                t.setName(type.getName());

                types.add(t);
            });

            wildPokemonBrief.setTypes(types);

            content.add(wildPokemonBrief);
        });

        CustomPage customPage = new CustomPage(content, prev, next);
        
        return customPage;
    }

    @GetMapping("/{id}")
    public WildPokemonDetailed getPokemon(@PathVariable("id") int id, HttpServletRequest request) {
        WildPokemon wildPokemon = service.findById(id);

        WildPokemonDetailed wildPokemonDetailed = new WildPokemonDetailed();
        wildPokemonDetailed.setId(wildPokemon.getId());
        wildPokemonDetailed.setName(wildPokemon.getName());
        wildPokemonDetailed.setPokedexId(wildPokemon.getPokedexId());
        wildPokemonDetailed.setSprite(wildPokemon.getSprite());

        WildPokemonDetailed.Stats stats = new WildPokemonDetailed.Stats();
        stats.setHp(wildPokemon.getStats().getHp());
        stats.setAtk(wildPokemon.getStats().getAtk());
        stats.setDef(wildPokemon.getStats().getDef());
        stats.setSpAtk(wildPokemon.getStats().getSpAtk());
        stats.setSpDef(wildPokemon.getStats().getSpDef());
        stats.setSpeed(wildPokemon.getStats().getSpeed());
        
        wildPokemonDetailed.setStats(stats);

        List<WildPokemonDetailed.Type> types = new ArrayList<WildPokemonDetailed.Type>();

        wildPokemon.getTypes().forEach(type -> {
            WildPokemonDetailed.Type t = new WildPokemonDetailed.Type();
            t.setId(type.getId());
            t.setName(type.getName());

            types.add(t);
        });

        wildPokemonDetailed.setTypes(types);

        List<WildPokemonDetailed.Ability> abilities = new ArrayList<WildPokemonDetailed.Ability>();

        wildPokemon.getAbilities().forEach(ability -> {
            WildPokemonDetailed.Ability a = new WildPokemonDetailed.Ability();
            a.setId(ability.getId());
            a.setName(ability.getName());

            abilities.add(a);
        });

        wildPokemonDetailed.setAbilities(abilities);

        List<WildPokemonDetailed.Move> moves = new ArrayList<WildPokemonDetailed.Move>();

        wildPokemon.getMoves().forEach(move -> {
            WildPokemonDetailed.Move m = new WildPokemonDetailed.Move();
            m.setId(move.getId());
            m.setName(move.getName());

            moves.add(m);
        });

        wildPokemonDetailed.setMoves(moves);

        return wildPokemonDetailed;
    }
}