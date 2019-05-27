package pokemon.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pokemon.server.dto.PokemonInfo;
import pokemon.server.persistence.dao.TeamPokemonRepository;
import pokemon.server.persistence.model.Ability;
import pokemon.server.persistence.model.Item;
import pokemon.server.persistence.model.Move;
import pokemon.server.persistence.model.Nature;
import pokemon.server.persistence.model.Pokemon;
import pokemon.server.persistence.model.Stats;
import pokemon.server.persistence.model.TeamPokemon;
import pokemon.server.persistence.model.TeamPokemon.Id;

@Service
public class TeamPokemonService implements ITeamPokemonService {

    @Autowired
    private TeamPokemonRepository repository;

    @Override
    public void save(TeamPokemon pokemon) {
        repository.save(pokemon);
    }

    @Override
    public int nextFreeId(String username, int teamId) {
        return repository.nextFreeId(username, teamId);
    }

    @Override
    public PokemonInfo findInfoById(Id id) {
        TeamPokemon pokemon = repository.findById(id).get();
        if (pokemon != null) {
            PokemonInfo info = new PokemonInfo();

            info.setId(pokemon.getId().getTeamPokemonId());

            Pokemon p = pokemon.getPokemon();
            info.setPokemonId(pokemon.getPokemon().getId());

            info.setNickname(pokemon.getNickname());

            Item item = pokemon.getItem();
            if (item != null) {
                info.setItem(new PokemonInfo.Item(item.getId(), item.getName()));
            }

            Nature nature = pokemon.getNature();
            info.setNature(new PokemonInfo.Nature(nature.getId(), nature.getName()));

            Ability ability = pokemon.getAbility();
            info.setAbility(new PokemonInfo.Ability(ability.getId(), ability.getName()));

            info.setSprite(pokemon.getPokemon().getSprite());
            
            Stats stats = p.getStats();
            info.setStats(new PokemonInfo.Stats(stats.getHp(), stats.getAtk(), stats.getDef(),
                    stats.getSpAtk(), stats.getSpDef(), stats.getSpeed()));

            Stats ivs = pokemon.getIvs();
            info.setIvs(new PokemonInfo.Stats(ivs.getHp(), ivs.getAtk(), ivs.getDef(),
                    ivs.getSpAtk(), ivs.getSpDef(), ivs.getSpeed()));

            Stats evs = pokemon.getEvs();
            info.setEvs(new PokemonInfo.Stats(evs.getHp(), evs.getAtk(), evs.getDef(),
                    evs.getSpAtk(), evs.getSpDef(), evs.getSpeed()));

            List<Move> moves = pokemon.getMoves();

            moves.forEach(move -> {
                info.getMoves().add(new PokemonInfo.Move(move.getId(), move.getName()));
            });            

            return info;
        }

        throw new RuntimeException("Could not find pokemon");
    }

}