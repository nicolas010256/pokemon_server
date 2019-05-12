package pokemon.server.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import pokemon.server.model.Move;
import pokemon.server.repository.MoveRepository;

@RestController
public class MoveController {

    @Autowired
    private MoveRepository moveRepository;

    @CrossOrigin
    @GetMapping("/move/{id}")
    public Optional<Move> getMove(@PathVariable("id") int id) {
        return moveRepository.findById(id);
    }
}