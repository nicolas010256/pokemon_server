package pokemon.server.controller.pokedex;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pokemon.server.persistence.model.Move;
import pokemon.server.service.IMoveService;

// Habilita Cross-Origin Resource Sharing para a classe
@CrossOrigin
// Define que a classe é um contralador REST
@RestController
// Define a rota base para a classe
@RequestMapping("/move")
public class MoveController {

    // Define que o spring faça o gerenciamento (Dependency Injection) do atributo
    @Autowired
    // Serviço de movimentos
    private IMoveService service;

    // Mapeia uma requisição GET para o método, na rota /move/{id}
    // {id} - parâmetro que fará parte da URL. Ex: /move/1, /move/2, /move/3
    @GetMapping("/{id}")
    // @PathVariable - define que o parâmetro fará parte da URL
    public Move getMove(@PathVariable("id") int id) {
        // Pesquisa e retorna a habilidade pelo id
        return service.findById(id);
    }
}