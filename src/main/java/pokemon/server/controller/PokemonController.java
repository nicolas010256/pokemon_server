package pokemon.server.controller;

import java.io.FileReader;
import java.io.IOException;

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
        JSONObject json = new JSONObject();
        try {
            StringBuffer buffer = new StringBuffer();
            FileReader reader = new FileReader(getClass().getResource("/pokemon/all.json").getFile());
            while (reader.ready()) {
                buffer.append((char) reader.read());
            }
            reader.close();
            JSONArray data = new JSONArray(buffer.toString());
            json.put("code", 200);
            json.put("message", "Success");
            json.put("data", data);

            HttpHeaders header = new HttpHeaders();
            header.setContentType(MediaType.APPLICATION_JSON);

            return new ResponseEntity<String>(json.toString(), header, HttpStatus.OK);
        } catch(IOException e) {
            json.put("code", 404);
            json.put("message", "Resource Not Found");
            json.put("data", JSONObject.NULL);

            return new ResponseEntity<String>(json.toString(), HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin
    @GetMapping("/pokemon/{id}")
    public ResponseEntity<String> getPokemon(@PathVariable("id") long id) {
        JSONObject json = new JSONObject();
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        
        try {
            String data = readFile(getClass().getResource("/pokemon/" + id + ".json").getFile());
            json.put("code", 200);
            json.put("message", "Success");
            json.put("data", new JSONObject(data));

            return new ResponseEntity<String>(json.toString(), header, HttpStatus.OK);
        } catch (IOException e) {
            json.put("code", 404);
            json.put("message", "Resource Not Found");
            json.put("data", JSONObject.NULL);

            return new ResponseEntity<String>(json.toString(), header, HttpStatus.NOT_FOUND);
        }
    }

    private String readFile(String file) throws IOException {
        StringBuffer buffer = new StringBuffer();
        FileReader reader = new FileReader(file);
        while (reader.ready()) {
            buffer.append((char) reader.read());
        }
        reader.close();
        return buffer.toString();
    }
}