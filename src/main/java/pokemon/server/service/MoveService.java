package pokemon.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pokemon.server.persistence.dao.MoveRepository;
import pokemon.server.persistence.model.Move;

@Service
public class MoveService implements IMoveService {

    @Autowired
    private MoveRepository repository;

    @Override
    public Move findById(Integer id) {
        return repository.findById(id).get();
    }

}