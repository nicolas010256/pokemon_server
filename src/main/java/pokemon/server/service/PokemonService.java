package pokemon.server.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pokemon.server.exception.ConflictException;
import pokemon.server.exception.ResourceNotFoundException;
import pokemon.server.persistence.dao.PokemonRepository;
import pokemon.server.persistence.model.Pokemon;
import pokemon.server.persistence.model.Pokemon.Id;

@Service
public class PokemonService  implements IPokemonService {

    @Autowired
    private PokemonRepository repository;

    @Override
    public void save(Pokemon pokemon) throws ConflictException {
        Optional<Pokemon> p = repository.findById(pokemon.getId());
        if (!p.isPresent()) {
            repository.save(pokemon);
        }
        
        throw new ConflictException("Pokemon Already Exists!");
    }

    @Override
    public int nextFreeId(String username, int teamId) {
        return repository.nextFreeId(username, teamId);
    }

    @Override
    public Pokemon findById(Id id) throws ResourceNotFoundException {
        Optional<Pokemon> pokemon = repository.findById(id);
        if (pokemon.isPresent()) {
            return pokemon.get(); 
        }

        throw new ResourceNotFoundException("Pokemon Not Found!");
    }

    @Override
    public void delete(Id id) throws ResourceNotFoundException {
        Pokemon pokemon = findById(id);
        repository.delete(pokemon);
    }

    @Override
    public void update(Pokemon pokemon) throws ResourceNotFoundException {
        Optional<Pokemon> p = repository.findById(pokemon.getId());
        if (p.isPresent()) {
            repository.save(pokemon);
        } else {
            throw new ResourceNotFoundException("Pokemon Not Found!");
        }       
    }

}