package pokemon.server.controller;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import pokemon.server.model.Pokemon;
import pokemon.server.repository.PokemonRepository;

@RestController
public class PokemonController {
    @Autowired
    private PokemonRepository pokemonRepository;

    @CrossOrigin
    @GetMapping("/pokemon")
    public Iterable<Pokemon> getPokemon() {
        // JSONArray json = null;
        // HttpHeaders header = new HttpHeaders();
        // header.setContentType(MediaType.APPLICATION_JSON);
        
        // try {
        //     String data = readFile("/pokemon/all.json");
        //     json = new JSONArray(data);
        //     return new ResponseEntity<String>(json.toString(), header, HttpStatus.OK);
        // } catch (IOException | NullPointerException e) {
        //     return new ResponseEntity<>("Erro", HttpStatus.NOT_FOUND);
        // }
        return pokemonRepository.findAll();
    }

    @CrossOrigin
    @GetMapping("/pokemon/{id}")
    public Optional<Pokemon> getPokemon(@PathVariable("id") long id) {
        // JSONObject json = new JSONObject();
        // HttpHeaders header = new HttpHeaders();
        // header.setContentType(MediaType.APPLICATION_JSON);
        
        // try {
        //     String data = readFile("/pokemon/" + id + ".json");
        //     json = new JSONObject(data);

        //     return new ResponseEntity<String>(json.toString(), header, HttpStatus.OK);
        // } catch (IOException | NullPointerException e) {

        //     return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        // }

        return pokemonRepository.findById(id);
    }

    private String readFile(String file) throws IOException {
        StringBuffer buffer = new StringBuffer();
        InputStreamReader reader = new InputStreamReader(getClass().getResourceAsStream(file));
        while (reader.ready()) {
            buffer.append((char) reader.read());
        }
        reader.close();
        return buffer.toString();
    }
}