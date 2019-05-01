package pokemon.server.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MoveController {
    
    @CrossOrigin
    @GetMapping("/move/{id}")
    public ResponseEntity getMove(@PathVariable("id") long id) {
        return null;
    }
}