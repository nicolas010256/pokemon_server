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

// Habilita Cross-Origin Resource Sharing para a classe
@CrossOrigin
// Define que a classe é um contralador REST
@RestController
// Define a rota base para a classe
@RequestMapping("/user/team/{teamId}/pokemon")
public class PokemonController {

    // Define que o spring faça o gerenciamento (Dependency Injection) do atributo
    @Autowired
    // Serviço de pokemon
    private IPokemonService service;

    // Mapeia uma requisição POST para o método, na rota /user/team/{teamId}/pokemon
    // {id} - parâmetro que fará parte da URL. Ex: /user/team/1/pokemon
    @PostMapping
    // @RequestAttribute - atributo da requisição
    // @PathVariable - define que o parâmetro fará parte da URL
    // @RequestBody - indidca que a informação virá no corpo (body) da requisição
    public void createPokemon(@RequestAttribute("username") String username, 
            @PathVariable("teamId") int teamId, @RequestBody List<Poke> list) {

        // Para cada item da lista, cria um pokemon
        list.forEach(info -> {
            // Cria model Pokemon
            Pokemon pokemon = new Pokemon();
        
            // Cria id do model, com o pokemon id, team id e username
            // service.nextFreeId - pega o próximo id livre na sequência
            Pokemon.Id id = new Pokemon.Id(service.nextFreeId(username, teamId), teamId, username);
            // Passa o id para entidade
            pokemon.setId(id);

            // Cria pokemon selvagem
            WildPokemon p = new WildPokemon();
            // Passa id do pokemon selvagem
            p.setId(info.getPokemonId());
            // Passa pokemon selvagem para o model Pokemon
            pokemon.setWildPokemon(p);

            // Passa nickname
            pokemon.setNickname(info.getName());

            // Cria model Ability
            Ability ability = new Ability();
            // Passa id
            ability.setId(info.getAbilityId());
            // Passa ability para o Pokemon
            pokemon.setAbility(ability);

            // Cria model Nature
            Nature nature = new Nature();
            // Passa id
            nature.setId(info.getNatureId());
            // Passa nature para o Pokemon
            pokemon.setNature(nature);

            // Cria model Item
            Item item = new Item();
            // Passa id
            item.setId(info.getItemId());
            // Passa item para o pokemon
            pokemon.setItem(item);

            // Cria model para ivs
            Stats ivs = new Stats();
            // Passa hp
            ivs.setHp(info.getIvs().getHp());
            // Passa atk
            ivs.setAtk(info.getIvs().getAtk());
            // Passa def
            ivs.setDef(info.getIvs().getDef());
            // Passa spAtk
            ivs.setSpAtk(info.getIvs().getSpAtk());
            // Passa spDef
            ivs.setSpDef(info.getIvs().getSpDef());
            // Passa speed
            ivs.setSpeed(info.getIvs().getSpeed());
            // Passa ivs para o Pokemon
            pokemon.setIvs(ivs);

            // Cria model para evs
            Stats evs = new Stats();
            // Passa hp
            evs.setHp(info.getEvs().getHp());
            // Passa atk
            evs.setAtk(info.getEvs().getAtk());
            // Passa def
            evs.setDef(info.getEvs().getDef());
            // Passa spAtk
            evs.setSpAtk(info.getEvs().getSpAtk());
            // Passa spDef
            evs.setSpDef(info.getEvs().getSpDef());
            // Passa speed
            evs.setSpeed(info.getEvs().getSpeed());
            // Passa evs para o Pokemon
            pokemon.setEvs(evs);

            // Cria uma lista de moves;
            List<Move> moves = new ArrayList<Move>();
        
            // Para cada move no DTO, cria um move e adiciona na lista
            info.getMoves().forEach(i -> {
                // Cria move
                Move move = new Move();
                // Passa id
                move.setId(i);
                // Adiciona na lista
                moves.add(move);
            });

            // Passa moves para o Pokemon
            pokemon.setMoves(moves);

            // Salva o Pokemon
            service.save(pokemon);
        });
    }

    @GetMapping("/{id}")
    public PokemonDetailed getPokemon(@RequestAttribute("username") String username, 
            @PathVariable("teamId") int teamId, @PathVariable("id") int id) {

        Pokemon pokemon = service.findById(new Pokemon.Id(id, teamId, username));

        PokemonDetailed pokemonDetailed = new PokemonDetailed();
        pokemonDetailed.setId(pokemon.getId().getTeamPokemonId());
        pokemonDetailed.setWildPokemonId(pokemon.getWildPokemon().getId());
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

        if (pokemon.getItem() != null) {

            PokemonDetailed.Item item = new PokemonDetailed.Item();
            item.setId(pokemon.getItem().getId());
            item.setName(pokemon.getItem().getName());

            pokemonDetailed.setItem(item); 
        }

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

        if (pokemon.getIvs() != null) {
            PokemonDetailed.Stats ivs = new PokemonDetailed.Stats();
            ivs.setHp(pokemon.getIvs().getHp());
            ivs.setAtk(pokemon.getIvs().getAtk());
            ivs.setDef(pokemon.getIvs().getDef());
            ivs.setSpAtk(pokemon.getIvs().getSpAtk());
            ivs.setSpDef(pokemon.getIvs().getSpDef());
            ivs.setSpeed(pokemon.getIvs().getSpeed());

            pokemonDetailed.setIvs(ivs); 
        }

        if (pokemon.getEvs() != null ) {
            PokemonDetailed.Stats evs = new PokemonDetailed.Stats();
            evs.setHp(pokemon.getEvs().getHp());
            evs.setAtk(pokemon.getEvs().getAtk());
            evs.setDef(pokemon.getEvs().getDef());
            evs.setSpAtk(pokemon.getEvs().getSpAtk());
            evs.setSpDef(pokemon.getEvs().getSpDef());
            evs.setSpeed(pokemon.getEvs().getSpeed());

            pokemonDetailed.setEvs(evs);  
        }       

        return pokemonDetailed;
    }

    @PutMapping("/{id}")
    public void updatePokemon(@RequestAttribute("username") String username, 
            @PathVariable("teamId") int teamId, @PathVariable("id") int id, 
            @RequestBody Poke info) {

        Pokemon pokemon = service.findById(new Pokemon.Id(id, teamId, username));

        if (info.getName() != null) {
            pokemon.setNickname(info.getName());
        }

        if (info.getAbilityId() != null) {
            Ability ability = new Ability();
            ability.setId(info.getAbilityId());
            pokemon.setAbility(ability);
        }

        if (info.getNatureId() != null) {
            Nature nature = new Nature();
            nature.setId(info.getNatureId());
            pokemon.setNature(nature);
        }
        
        if (info.getItemId() != null) {
            Item item = new Item();
            item.setId(info.getItemId());
            pokemon.setItem(item);
        }

        if (info.getIvs() != null) {
            Stats ivs = pokemon.getIvs();

            if (info.getIvs().getHp() != null)
                ivs.setHp(info.getIvs().getHp());
            if (info.getIvs().getAtk() != null)
                ivs.setAtk(info.getIvs().getAtk());
            if (info.getIvs().getDef() != null)
                ivs.setDef(info.getIvs().getDef());
            if (info.getIvs().getSpAtk() != null)
                ivs.setSpAtk(info.getIvs().getSpAtk());
            if (info.getIvs().getSpDef() != null)
                ivs.setSpDef(info.getIvs().getSpDef());
            if (info.getIvs().getSpeed() != null)
                ivs.setSpeed(info.getIvs().getSpeed());
        }

        if (info.getEvs() != null) {
            Stats evs = pokemon.getIvs();

            if (info.getEvs().getHp() != null)
                evs.setHp(info.getEvs().getHp());
            if (info.getEvs().getAtk() != null)
                evs.setAtk(info.getEvs().getAtk());
            if (info.getEvs().getDef() != null)
                evs.setDef(info.getEvs().getDef());
            if (info.getEvs().getSpAtk() != null)
                evs.setSpAtk(info.getEvs().getSpAtk());
            if (info.getEvs().getSpDef() != null)
                evs.setSpDef(info.getEvs().getSpDef());
            if (info.getEvs().getSpeed() != null)
                evs.setSpeed(info.getEvs().getSpeed());
        }

        if (info.getMoves() != null) {
            List<Move> moves = new ArrayList<Move>();
    
            info.getMoves().forEach(i -> {
                Move move = new Move();
                move.setId(i);
                moves.add(move);
            });

            pokemon.setMoves(moves);
        }

        service.save(pokemon);
    }
    
    // Mapeia uma requisição DELETE para o método, na rota /user/team/{teamId}/pokemon/{id}
    // {id} - parâmetro que fará parte da URL. Ex: /user/team/1/pokemon/1
    @DeleteMapping("/{id}")
    // RequestsAttribute - atributo da requisição
    // @PathVariable - define que o parâmetro fará parte da URL
    public void deletePokemon(@RequestAttribute("username") String username, 
            @PathVariable("teamId") int teamId,@PathVariable("id") int id) {

        // Deleta o pokemon
        service.delete(new Pokemon.Id(id, teamId, username));
    }
}