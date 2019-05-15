package pokemon.server.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pokemon.server.persistence.model.Move;
import pokemon.server.service.IMoveService;

@CrossOrigin
@RestController
@RequestMapping("/move")
public class MoveController {

    @Autowired
    private IMoveService service;

    @GetMapping("/{id}")
    public Move getMove(@PathVariable("id") int id) {
        return service.findById(id);
    }
}