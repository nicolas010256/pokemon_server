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
import pokemon.server.persistence.model.Nature;
import pokemon.server.service.INatureService;
import pokemon.server.util.PaginationUtil;

@CrossOrigin
@RestController
@RequestMapping("/nature")
public class NatureController {

    @Autowired
    private INatureService service;

    @GetMapping
    public CustomPage getAllNatures(@RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "20") int size,
            UriComponentsBuilder uriBuilder) {

        Page<Nature> naturePage = service.findAll(page, size);

        PaginationUtil paginationUtil = new PaginationUtil(naturePage, uriBuilder);

        String prev = paginationUtil.getPrev();
        String next = paginationUtil.getNext();

        CustomPage customPage = new CustomPage(naturePage.getContent(), prev, next);
        
        return customPage;
    }

    @GetMapping("/{id}")
    public Nature getById(@PathVariable("id") int id) {
        return service.findById(id);
    }
}