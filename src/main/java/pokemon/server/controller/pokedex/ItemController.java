package pokemon.server.controller.pokedex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import pokemon.server.dto.CustomPage;
import pokemon.server.persistence.model.Item;
import pokemon.server.service.IItemService;
import pokemon.server.util.PaginationUtil;

// Habilita Cross-Origin Resource Sharing para a classe
@CrossOrigin
// Define que a classe é um contralador REST
@RestController
// Define a rota base para a classe
@RequestMapping("/item")
public class ItemController {

    // Define que o spring faça o gerenciamento (Dependency Injection) do atributo
    @Autowired
    // Serviço de itens
    private IItemService service;
    
    // Mapeia uma requisição GET para o método, na rota /item
    @GetMapping
    // @RequestParam - define que o parâmetro virá na URL. Ex: /ability?page=5&size=2
    // value - nome do parâmetro na URL
    // defaultValue - valor padrão do parâmetro
    // UriComponentsBuilder - Objeto que conterá a URL e será urilizado na paginação
    // CustomPage - DTO utilizada na paginação
    public CustomPage getAllItems(@RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "20") int size,
            UriComponentsBuilder uriBuilder) {
        
        // Pesquisa itens, utilizando paginação
        Page<Item> itemPage = service.findAll(page, size);

        // Objeto de utilidade para paginação
        PaginationUtil paginationUtil = new PaginationUtil(itemPage, uriBuilder);

        // Define a URL da página anterior
        String prev = paginationUtil.getPrev();
        // Define a URL da página posterior
        String next = paginationUtil.getNext();

        // Cria DTO (Página) passando seu conteudo, URL da página anterior e a URL da página posterior
        CustomPage customPage = new CustomPage(itemPage.getContent(), prev, next);

        // Retorna DTO
        return customPage;
    }

    // Mapeia uma requisição GET para o método, na rota /item/{id}
    // {id} - parâmetro que fará parte da URL. Ex: /item/1, /item/2, /item/3
    @GetMapping("/{id}")
    // @PathVariable - define que o parâmetro fará parte da URL
    public Item getItemById(@PathVariable("id") int id) {
        // Pesquisa e retorna o item pelo id
        return service.findById(id);
    }
}