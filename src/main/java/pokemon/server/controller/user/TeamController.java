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
    @PostMapping()
    public void createTeam(@RequestAttribute("username") String username, @RequestBody String name) {
        Team team = new Team();
        Team.Id id = new Team.Id(service.nextFreeId(), username);
        team.setId(id);
        team.setName(name);
        service.save(team);
    }

    @GetMapping()
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
    public TeamBrief getTeam(@RequestAttribute("username") String username, @PathVariable("id") int id) {
        Team team = service.findById(new Team.Id(id, username));

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

        return teamBrief;
    }

    @PutMapping("/{id}")
    public void updateTeam(@RequestAttribute("username") String username, @PathVariable("id") int teamId,
             @RequestBody String name) {

        Team team = new Team();
        Team.Id id = new Team.Id(teamId, username);
        team.setId(id);
        team.setName(name);
        service.save(team);
    }

    @DeleteMapping("/{id}")
    public void deleteTeam(@RequestAttribute("username") String username, @PathVariable("id") int id) {
        service.delete(new Team.Id(id, username));
    }
}