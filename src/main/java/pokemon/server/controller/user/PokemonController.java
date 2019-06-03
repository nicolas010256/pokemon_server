package pokemon.server.controller.user;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pokemon.server.dto.Poke;
import pokemon.server.dto.PokemonDetailed;
import pokemon.server.persistence.model.Ability;
import pokemon.server.persistence.model.Item;
import pokemon.server.persistence.model.Move;
import pokemon.server.persistence.model.Nature;
import pokemon.server.persistence.model.Pokemon;
import pokemon.server.persistence.model.Stats;
import pokemon.server.persistence.model.WildPokemon;
import pokemon.server.service.IPokemonService;

@CrossOrigin
@RestController
@RequestMapping("/user/team/{teamId}/pokemon")
public class PokemonController {

    @Autowired
    private IPokemonService service;

    @PostMapping
    public void createPokemon(@RequestAttribute("username") String username, 
            @PathVariable("teamId") int teamId, @RequestBody Poke info) {
        
        Pokemon pokemon = new Pokemon();
        
        Pokemon.Id id = new Pokemon.Id(service.nextFreeId(username, teamId), teamId, username);
        pokemon.setId(id);

        WildPokemon p = new WildPokemon();
        p.setId(info.getPokemonId());
        pokemon.setWildPokemon(p);

        pokemon.setNickname(info.getName());

        Ability ability = new Ability();
        ability.setId(info.getAbilityId());
        pokemon.setAbility(ability);

        Nature nature = new Nature();
        nature.setId(info.getNatureId());
        pokemon.setNature(nature);

        Item item = new Item();
        item.setId(info.getItemId());
        pokemon.setItem(item);

        Stats ivs = new Stats();
        ivs.setHp(info.getIvs().getHp());
        ivs.setAtk(info.getIvs().getAtk());
        ivs.setDef(info.getIvs().getDef());
        ivs.setSpAtk(info.getIvs().getSpAtk());
        ivs.setSpDef(info.getIvs().getSpDef());
        ivs.setSpeed(info.getIvs().getSpeed());
        pokemon.setIvs(ivs);

        Stats evs = new Stats();
        evs.setHp(info.getEvs().getHp());
        evs.setAtk(info.getEvs().getAtk());
        evs.setDef(info.getEvs().getDef());
        evs.setSpAtk(info.getEvs().getSpAtk());
        evs.setSpDef(info.getEvs().getSpDef());
        evs.setSpeed(info.getEvs().getSpeed());
        pokemon.setEvs(evs);

        List<Move> moves = new ArrayList<Move>();
    
        info.getMoves().forEach(i -> {
            Move move = new Move();
            move.setId(i);
            moves.add(move);
        });

        pokemon.setMoves(moves);

        service.save(pokemon);
    }

    @GetMapping("/{id}")
    public PokemonDetailed getPokemon(@RequestAttribute("username") String username, 
            @PathVariable("teamId") int teamId, @PathVariable("id") int id) {

        Pokemon pokemon = service.findById(new Pokemon.Id(id, teamId, username));

        PokemonDetailed pokemonDetailed = new PokemonDetailed();
        pokemonDetailed.setId(pokemon.getId().getTeamPokemonId());
        pokemonDetailed.setName(pokemon.getNickname());
        pokemonDetailed.setSprite(pokemon.getWildPokemon().getSprite());

        PokemonDetailed.Nature nature = new PokemonDetailed.Nature();
        nature.setId(pokemon.getNature().getId());
        nature.setName(pokemon.getNature().getName());

        pokemonDetailed.setNature(nature);

        PokemonDetailed.Ability ability = new PokemonDetailed.Ability();
        ability.setId(pokemon.getAbility().getId());
        ability.setName(pokemon.getAbility().getName());

        pokemonDetailed.setAbility(ability);

        PokemonDetailed.Item item = new PokemonDetailed().getItem();
        item.setId(pokemon.getItem().getId());
        item.setName(pokemon.getItem().getName());

        pokemonDetailed.setItem(item);

        List<PokemonDetailed.Move> moves = new ArrayList<PokemonDetailed.Move>();

        pokemon.getMoves().forEach(m -> {
            PokemonDetailed.Move mm = new PokemonDetailed.Move();
            mm.setId(m.getId());
            mm.setName(m.getName());

            moves.add(mm);
        });

        pokemonDetailed.setMoves(moves);

        PokemonDetailed.Stats stats = new PokemonDetailed.Stats();
        stats.setHp(pokemon.getWildPokemon().getStats().getHp());
        stats.setAtk(pokemon.getWildPokemon().getStats().getAtk());
        stats.setDef(pokemon.getWildPokemon().getStats().getDef());
        stats.setSpAtk(pokemon.getWildPokemon().getStats().getSpAtk());
        stats.setSpDef(pokemon.getWildPokemon().getStats().getSpDef());
        stats.setSpeed(pokemon.getWildPokemon().getStats().getSpeed());

        pokemonDetailed.setStats(stats);

        PokemonDetailed.Stats ivs = new PokemonDetailed.Stats();
        ivs.setHp(pokemon.getIvs().getHp());
        ivs.setAtk(pokemon.getIvs().getAtk());
        ivs.setDef(pokemon.getIvs().getDef());
        ivs.setSpAtk(pokemon.getIvs().getSpAtk());
        ivs.setSpDef(pokemon.getIvs().getSpDef());
        ivs.setSpeed(pokemon.getIvs().getSpeed());

        pokemonDetailed.setIvs(ivs);
        
        PokemonDetailed.Stats evs = new PokemonDetailed.Stats();
        evs.setHp(pokemon.getEvs().getHp());
        evs.setAtk(pokemon.getEvs().getAtk());
        evs.setDef(pokemon.getEvs().getDef());
        evs.setSpAtk(pokemon.getEvs().getSpAtk());
        evs.setSpDef(pokemon.getEvs().getSpDef());
        evs.setSpeed(pokemon.getEvs().getSpeed());

        pokemonDetailed.setEvs(evs);         

        return pokemonDetailed;
    }

    @PutMapping("/{id}")
    public void updatePokemon(@RequestAttribute("username") String username, 
            @PathVariable("teamId") int teamId, @PathVariable("id") int id, 
            @RequestBody Poke info) {

        Pokemon pokemon = service.findById(new Pokemon.Id(id, teamId, username));

        pokemon.setNickname(info.getName());

        Ability ability = new Ability();
        ability.setId(info.getAbilityId());
        pokemon.setAbility(ability);

        Nature nature = new Nature();
        nature.setId(info.getNatureId());
        pokemon.setNature(nature);

        Item item = new Item();
        item.setId(info.getItemId());
        pokemon.setItem(item);

        Stats ivs = new Stats();
        ivs.setHp(info.getIvs().getHp());
        ivs.setAtk(info.getIvs().getAtk());
        ivs.setDef(info.getIvs().getDef());
        ivs.setSpAtk(info.getIvs().getSpAtk());
        ivs.setSpDef(info.getIvs().getSpDef());
        ivs.setSpeed(info.getIvs().getSpeed());
        pokemon.setIvs(ivs);

        Stats evs = new Stats();
        evs.setHp(info.getEvs().getHp());
        evs.setAtk(info.getEvs().getAtk());
        evs.setDef(info.getEvs().getDef());
        evs.setSpAtk(info.getEvs().getSpAtk());
        evs.setSpDef(info.getEvs().getSpDef());
        evs.setSpeed(info.getEvs().getSpeed());
        pokemon.setEvs(evs);

        List<Move> moves = new ArrayList<Move>();
    
        info.getMoves().forEach(i -> {
            Move move = new Move();
            move.setId(i);
            moves.add(move);
        });

        pokemon.setMoves(moves);

        service.save(pokemon);
    }

    @DeleteMapping("/{id}")
    public void deletePokemon(@RequestAttribute("username") String username, 
            @PathVariable("teamId") int teamId,@PathVariable("id") int id) {

        service.delete(new Pokemon.Id(id, teamId, username));
    }
}