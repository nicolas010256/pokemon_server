package pokemon.server.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pokemon.server.exception.ResourceNotFoundException;
import pokemon.server.persistence.dao.MoveRepository;
import pokemon.server.persistence.model.Move;

@Service
public class MoveService implements IMoveService {

    @Autowired
    private MoveRepository repository;

    @Override
    public Move findById(Integer id) throws ResourceNotFoundException {
        Optional<Move> move = repository.findById(id);
        if (move.isPresent()) {
            return move.get();
        }
        
        throw new ResourceNotFoundException("Move Not Found");
    }

}