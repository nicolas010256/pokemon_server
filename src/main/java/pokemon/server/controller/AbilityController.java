package pokemon.server.controller;

<<<<<<< HEAD
import java.io.IOException;
import java.io.InputStreamReader;

import org.json.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
=======
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
>>>>>>> dev
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD
@RestController
public class AbilityController {

    @GetMapping("/ability/{id}")
    public ResponseEntity<String> getAbility(@PathVariable("id") long id) {
        JSONObject json = new JSONObject();
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        
        try {
            String data = readFile("/ability/" + id + ".json");
            json = new JSONObject(data);

            return new ResponseEntity<String>(json.toString(), header, HttpStatus.OK);
        } catch (IOException | NullPointerException e) {

            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    private String readFile(String file) throws IOException {
        StringBuffer buffer = new StringBuffer();
        InputStreamReader reader = new InputStreamReader(getClass().getResourceAsStream(file));
        while (reader.ready()) {
            buffer.append((char) reader.read());
        }
        reader.close();
        return buffer.toString();
=======
import pokemon.server.model.Ability;
import pokemon.server.repository.AbilityRepository;

@RestController
@CrossOrigin
public class AbilityController {

    @Autowired
    private AbilityRepository abilityRepository;

    @GetMapping("/ability/{id}")
    public Optional<Ability> getAbility(@PathVariable("id") int id) {
        return abilityRepository.findById(id);
>>>>>>> dev
    }
}