package pokemon.server.controller.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import pokemon.server.dto.CustomPage;
import pokemon.server.dto.TeamBrief;
import pokemon.server.dto.TeamDetailed;
import pokemon.server.dto.TeamInfo;
import pokemon.server.persistence.model.Team;
import pokemon.server.service.ITeamService;
import pokemon.server.util.PaginationUtil;

@CrossOrigin
@RestController
@RequestMapping("/user/team")
public class TeamController {

    @Autowired
    private ITeamService service;
    
    @CrossOrigin
    @PostMapping
    public int createTeam(@RequestAttribute("username") String username, @RequestBody TeamInfo info) {
        Team team = new Team();
        Team.Id id = new Team.Id(service.nextFreeId(username), username);
        team.setId(id);
        team.setName(info.getName());
        service.save(team);
        return id.getTeamId();
    }

    @GetMapping
    public CustomPage getAllTeams(@RequestAttribute("username") String username,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "20") int size,
            UriComponentsBuilder uriBuilder) {

        Page<Team> teamPage = service.findByUsername(username, page, size);

        PaginationUtil paginationUtil = new PaginationUtil(teamPage, uriBuilder);

        String prev = paginationUtil.getPrev();
        String next = paginationUtil.getNext();

        List<TeamBrief> content = new ArrayList<TeamBrief>();

        teamPage.getContent().forEach(team -> {
            TeamBrief teamBrief = new TeamBrief();
            teamBrief.setId(team.getId().getTeamId());
            teamBrief.setName(team.getName());

            List<TeamBrief.Pokemon> pokemon = new ArrayList<TeamBrief.Pokemon>();

            team.getPokemon().forEach(p -> {
                TeamBrief.Pokemon pp = new TeamBrief.Pokemon();
                pp.setId(p.getId().getTeamPokemonId());
                pp.setName(p.getNickname());
                pp.setSprite(p.getWildPokemon().getSprite());

                pokemon.add(pp);
            });

            teamBrief.setPokemon(pokemon);

            content.add(teamBrief);
        });

        CustomPage customPage = new CustomPage(content, prev, next);

        return customPage;
    }

    @GetMapping("/{id}")
    public TeamDetailed getTeam(@RequestAttribute("username") String username, @PathVariable("id") int id) {
        Team team = service.findById(new Team.Id(id, username));

        TeamDetailed teamDetailed = new TeamDetailed();
        teamDetailed.setId(team.getId().getTeamId());
        teamDetailed.setName(team.getName());

        List<TeamDetailed.Pokemon> pokemon = new ArrayList<TeamDetailed.Pokemon>();

        team.getPokemon().forEach(p -> {
            TeamDetailed.Pokemon pp = new TeamDetailed.Pokemon();
            pp.setId(p.getId().getTeamPokemonId());
            pp.setName(p.getNickname());
            pp.setSprite(p.getWildPokemon().getSprite());
            pp.setPokemonId(p.getWildPokemon().getId());
            
            TeamDetailed.Pokemon.Ability ability = new TeamDetailed.Pokemon.Ability();
            ability.setId(p.getAbility().getId());
            ability.setName(p.getAbility().getName());

            pp.setAbility(ability);

            TeamDetailed.Pokemon.Item item = new TeamDetailed.Pokemon.Item();
            item.setId(p.getItem().getId());
            item.setName(p.getItem().getName());

            pp.setItem(item);

            TeamDetailed.Pokemon.Nature nature = new TeamDetailed.Pokemon.Nature();
            nature.setId(p.getNature().getId());
            nature.setName(p.getNature().getName());

            pp.setNature(nature);

            TeamDetailed.Pokemon.Stats stats = new TeamDetailed.Pokemon.Stats();
            stats.setHp(p.getWildPokemon().getStats().getHp());
            stats.setAtk(p.getWildPokemon().getStats().getAtk());
            stats.setDef(p.getWildPokemon().getStats().getDef());
            stats.setSpAtk(p.getWildPokemon().getStats().getSpAtk());
            stats.setSpDef(p.getWildPokemon().getStats().getSpDef());
            stats.setSpeed(p.getWildPokemon().getStats().getSpeed());

            pp.setStats(stats);

            TeamDetailed.Pokemon.Stats ivs = new TeamDetailed.Pokemon.Stats();
            stats.setHp(p.getIvs().getHp());
            stats.setAtk(p.getIvs().getAtk());
            stats.setDef(p.getIvs().getDef());
            stats.setSpAtk(p.getIvs().getSpAtk());
            stats.setSpDef(p.getIvs().getSpDef());
            stats.setSpeed(p.getIvs().getSpeed());

            pp.setIvs(ivs);

            TeamDetailed.Pokemon.Stats evs = new TeamDetailed.Pokemon.Stats();
            stats.setHp(p.getEvs().getHp());
            stats.setAtk(p.getEvs().getAtk());
            stats.setDef(p.getEvs().getDef());
            stats.setSpAtk(p.getEvs().getSpAtk());
            stats.setSpDef(p.getEvs().getSpDef());
            stats.setSpeed(p.getEvs().getSpeed());

            pp.setEvs(evs);


            List<TeamDetailed.Pokemon.Move> moves = new ArrayList<>();

            p.getMoves().forEach(m -> {
                TeamDetailed.Pokemon.Move move = new  TeamDetailed.Pokemon.Move();
                move.setId(m.getId());
                move.setName(m.getName());

                moves.add(move);
            });

            pp.setMoves(moves);

            pokemon.add(pp);
        });

        teamDetailed.setPokemon(pokemon);

        return teamDetailed;
    }

    @PutMapping("/{id}")
    public void updateTeam(@RequestAttribute("username") String username, @PathVariable("id") int teamId,
             @RequestBody TeamInfo info) {
       
        Team.Id id = new Team.Id(teamId, username);
        Team team = service.findById(id);
        team.setName(info.getName());
        service.save(team);
    }

    @DeleteMapping("/{id}")
    public void deleteTeam(@RequestAttribute("username") String username, @PathVariable("id") int id) {
        service.delete(new Team.Id(id, username));
    }
}