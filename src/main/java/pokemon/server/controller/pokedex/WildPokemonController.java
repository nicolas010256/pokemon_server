package pokemon.server.controller.pokedex;

import java.util.ArrayList;
import java.util.List;


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

// Habilita Cross-Origin Resource Sharing para a classe
@CrossOrigin
// Define que a classe é um contralador REST
@RestController
// Define a rota base para a classe
@RequestMapping("/pokemon")
public class WildPokemonController {
    
    // Define que o spring faça o gerenciamento (Dependency Injection) do atributo
    @Autowired
    // Serviço de pokemon selvangem
    private IWildPokemonService service;
    
    // Mapeia uma requisição GET para o método, na rota /pokemon
    @GetMapping
    // @RequestParam - define que o parâmetro virá na URL. Ex: /pokemon?page=5&size=2
    // value - nome do parâmetro na URL
    // defaultValue - valor padrão do parâmetro
    // UriComponentsBuilder - Objeto que conterá a URL e será urilizado na paginação
    // CustomPage - DTO utilizada na paginação
    public CustomPage getPokemon(
            @RequestParam(value = "size", defaultValue = "20") int size,
            @RequestParam(value = "page", defaultValue = "0") int page,
            UriComponentsBuilder uriBuilder) {

        // Pesquisa pokemon selvagem, utilizando paginação
        Page<WildPokemon> wildPokemonPage = service.findAllDefault(page, size);

        // Objeto de utilidade para paginação
        PaginationUtil paginationUtil = new PaginationUtil(wildPokemonPage, uriBuilder);

        // Define a URL da página anterior
        String prev = paginationUtil.getPrev();
        // Define a URL da página posterior
        String next = paginationUtil.getNext();

        // Cria uma lista do DTO WildPokemonBrief que será utilizada como conteúdo da página
        List<WildPokemonBrief> content = new ArrayList<WildPokemonBrief>();

        // Para cada pokemon selvagem encontrado, cria um DTO e passa para a lista de DTO's
        wildPokemonPage.getContent().forEach(wildPokemon -> {
            // Cria DTO
            WildPokemonBrief wildPokemonBrief = new WildPokemonBrief();
            // Passa id
            wildPokemonBrief.setId(wildPokemon.getId());
            // Passa name
            wildPokemonBrief.setName(wildPokemon.getName());
            // Passa sprite
            wildPokemonBrief.setSprite(wildPokemon.getSprite());
            // Passa pokedexId
            wildPokemonBrief.setPokedexId(wildPokemon.getPokedexId());
            
            // Cria uma lista com os tipos
            List<WildPokemonBrief.Type> types = new ArrayList<WildPokemonBrief.Type>();

            // Para cada tipo do pokemon selvagem, cria um DTO e passa para a lista
            wildPokemon.getTypes().forEach(type -> {
                // Cria DTO
                WildPokemonBrief.Type t = new WildPokemonBrief.Type();
                // Passa id
                t.setId(type.getId());
                // Passa name
                t.setName(type.getName());

                // Adiciona na lista
                types.add(t);
            });

            // Passa a lista de tipos
            wildPokemonBrief.setTypes(types);

            WildPokemonBrief.Stats stats = new WildPokemonBrief.Stats();
            stats.setHp(wildPokemon.getStats().getHp());
            stats.setAtk(wildPokemon.getStats().getAtk());
            stats.setDef(wildPokemon.getStats().getDef());
            stats.setSpAtk(wildPokemon.getStats().getSpAtk());
            stats.setSpDef(wildPokemon.getStats().getSpDef());
            stats.setSpeed(wildPokemon.getStats().getSpeed());

            wildPokemonBrief.setStats(stats);

            // Adiciona na lista
            content.add(wildPokemonBrief);
        });

        // Cria DTO (Página) passando seu conteudo, URL da página anterior e a URL da página posterior
        CustomPage customPage = new CustomPage(content, prev, next);
        
        // Retorna DTO
        return customPage;
    }

    // Mapeia uma requisição GET para o método, na rota /pokemon/{id}
    // {id} - parâmetro que fará parte da URL. Ex: /pokemon/1, /pokemon/2, /pokemon/3
    @GetMapping("/{id}")
    // @PathVariable - define que o parâmetro fará parte da URL
    public WildPokemonDetailed getPokemon(@PathVariable("id") int id) {
        // Pesquisa o pokemon selvagem pelo id.
        WildPokemon wildPokemon = service.findById(id);

        //Cria DTO
        WildPokemonDetailed wildPokemonDetailed = new WildPokemonDetailed();
        // Passa id
        wildPokemonDetailed.setId(wildPokemon.getId());
        // Passa name
        wildPokemonDetailed.setName(wildPokemon.getName());
        // Passa pokedexId
        wildPokemonDetailed.setPokedexId(wildPokemon.getPokedexId());
        // Passa sprite
        wildPokemonDetailed.setSprite(wildPokemon.getSprite());

        // Cria DTO para os stats
        WildPokemonDetailed.Stats stats = new WildPokemonDetailed.Stats();
        // Passa hp
        stats.setHp(wildPokemon.getStats().getHp());
        // Passa atk
        stats.setAtk(wildPokemon.getStats().getAtk());
        // Passa def
        stats.setDef(wildPokemon.getStats().getDef());
        // Passa spAtk
        stats.setSpAtk(wildPokemon.getStats().getSpAtk());
        // Passa spDef
        stats.setSpDef(wildPokemon.getStats().getSpDef());
        // Passa speed
        stats.setSpeed(wildPokemon.getStats().getSpeed());
        
        // Passa DTO stats
        wildPokemonDetailed.setStats(stats);

        // Cria lista de types
        List<WildPokemonDetailed.Type> types = new ArrayList<WildPokemonDetailed.Type>();

        // Para cada type do pokemon selvagem, cria um DTO e passa para a lista
        wildPokemon.getTypes().forEach(type -> {
            // Cria DTO
            WildPokemonDetailed.Type t = new WildPokemonDetailed.Type();
            // Passa id
            t.setId(type.getId());
            // Passa name
            t.setName(type.getName());

            // Adiciona na lista
            types.add(t);
        });


        // Passa lista de types
        wildPokemonDetailed.setTypes(types);

        // Cria lista de abilities
        List<WildPokemonDetailed.Ability> abilities = new ArrayList<WildPokemonDetailed.Ability>();

        // Para cada ability do pokemon selvagem, cria um DTO e passa para a lista
        wildPokemon.getAbilities().forEach(ability -> {
            // Cria DTO
            WildPokemonDetailed.Ability a = new WildPokemonDetailed.Ability();
            // Passa id
            a.setId(ability.getId());
            // Passa name
            a.setName(ability.getName());

            // Adiciona na lista
            abilities.add(a);
        });

        // Passa lista de abilities
        wildPokemonDetailed.setAbilities(abilities);

        // Cria lista de moves
        List<WildPokemonDetailed.Move> moves = new ArrayList<WildPokemonDetailed.Move>();

        // Para cada move do pokemon selvagem, cria um DTO e passa para a lista
        wildPokemon.getMoves().forEach(move -> {
            // Cria DTO
            WildPokemonDetailed.Move m = new WildPokemonDetailed.Move();
            // Passa id
            m.setId(move.getId());
            // Passa name
            m.setName(move.getName());

            m.setPower(move.getPower());

            m.setAccuracy(move.getAccuracy());

            m.setType(move.getType().getName());

            m.setDamageCategory(move.getDamageCategory());

            // Adiciona na lista
            moves.add(m);
        });

        // Passa lista de moves
        wildPokemonDetailed.setMoves(moves);

        // retorna DTO
        return wildPokemonDetailed;
    }
}