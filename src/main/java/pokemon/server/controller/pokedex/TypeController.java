package pokemon.server.controller.pokedex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pokemon.server.persistence.model.Type;
import pokemon.server.service.ITypeService;

// Habilita Cross-Origin Resource Sharing para a classe
@CrossOrigin
// Define que a classe é um contralador REST
@RestController
// Define a rota base para a classe
@RequestMapping("/type")
public class TypeController {

    // Define que o spring faça o gerenciamento (Dependency Injection) do atributo
    @Autowired
    // Serviço de tipos
    private ITypeService service;

    // Mapeia uma requisição GET para o método, na rota /type/{id}
    // {id} - parâmetro que fará parte da URL. Ex: /type/1, /type/2, /type/3
    @GetMapping("/{id}")
    public Type getType(@PathVariable("id") Integer id) {
        // Pesquisa e retorna o tipo pelo id
        return service.findById(id);
    }
}