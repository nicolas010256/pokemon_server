package pokemon.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pokemon.server.persistence.dao.PokemonRepository;
import pokemon.server.persistence.model.Pokemon;
import pokemon.server.persistence.model.Pokemon.Id;

@Service
public class PokemonService  implements IPokemonService {

    @Autowired
    private PokemonRepository repository;

    @Override
    public void save(Pokemon pokemon) {
        repository.save(pokemon);
    }

    @Override
    public int nextFreeId(String username, int teamId) {
        return repository.nextFreeId(username, teamId);
    }

    @Override
    public Pokemon findById(Id id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(Id id) {
        repository.deleteById(id);
    }

}