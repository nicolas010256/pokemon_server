package pokemon.server.controller;

import java.io.IOException;
import java.io.InputStreamReader;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PokemonController {
    @CrossOrigin
    @GetMapping("/pokemon")
    public ResponseEntity<String> getPokemon() {
        JSONArray json = null;
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        
        try {
            String data = readFile("/pokemon/all.json");
            json = new JSONArray(data);
            return new ResponseEntity<String>(json.toString(), header, HttpStatus.OK);
        } catch (IOException | NullPointerException e) {
            return new ResponseEntity<>("Erro", HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin
    @GetMapping("/pokemon/{id}")
    public ResponseEntity<String> getPokemon(@PathVariable("id") long id) {
        JSONObject json = new JSONObject();
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        
        try {
            String data = readFile("/pokemon/" + id + ".json");
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
    }
}