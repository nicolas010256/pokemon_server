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
import pokemon.server.dto.PokemonInfo;
import pokemon.server.persistence.model.Ability;
import pokemon.server.persistence.model.Item;
import pokemon.server.persistence.model.Move;
import pokemon.server.persistence.model.Nature;
import pokemon.server.persistence.model.Pokemon;
import pokemon.server.persistence.model.Stats;
import pokemon.server.persistence.model.TeamPokemon;
import pokemon.server.service.TeamPokemonService;

@CrossOrigin
@RestController
@RequestMapping("/user/team/{teamId}/pokemon")
public class PokemonController {

    @Autowired
    private TeamPokemonService service;

    @PostMapping()
    public void createPokemon(@RequestAttribute("username") String username, 
            @PathVariable("teamId") int teamId, @RequestBody Poke info) {
        
        TeamPokemon pokemon = new TeamPokemon();
        
        TeamPokemon.Id id = new TeamPokemon.Id(service.nextFreeId(username, teamId), teamId, username);
        pokemon.setId(id);

        Pokemon p = new Pokemon();
        p.setId(info.getPokemonId());
        pokemon.setPokemon(p);

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
    public PokemonInfo getPokemon(@RequestAttribute("username") String username, 
            @PathVariable("teamId") int teamId, @PathVariable("id") int id) {

        return service.findInfoById(new TeamPokemon.Id(id, teamId, username));
    }

    @PutMapping("/{id}")
    public void updatePokemon(@RequestAttribute("username") String username, 
            @PathVariable("teamId") int teamId, @RequestBody PokemonInfo info) {

    }

    @DeleteMapping("/{id}")
    public void deletePokemon(@RequestAttribute("username") String username, 
            @PathVariable("teamId") int teamId,@PathVariable("id") int id) {

            
    }
}