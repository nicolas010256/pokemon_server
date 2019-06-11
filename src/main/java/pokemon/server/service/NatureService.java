package pokemon.server.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import pokemon.server.exception.ResourceNotFoundException;
import pokemon.server.persistence.dao.NatureRepository;
import pokemon.server.persistence.model.Nature;

@Service
public class NatureService implements INatureService {

    @Autowired
    private NatureRepository repository;

    @Override
    public Page<Nature> findAll(int page, int size) throws ResourceNotFoundException {
        Page<Nature> p = repository.findAll(PageRequest.of(page, size));
        if (p.hasContent()) {
            return p;
        }
        
        throw new ResourceNotFoundException("Nature Not Found!");
    }

    @Override
    public Nature findById(Integer id) throws ResourceNotFoundException {
        Optional<Nature> nature = repository.findById(id);
        if (nature.isPresent()) {
            return nature.get();
        }
        
        throw new ResourceNotFoundException("Nature Not Found!");
    }

}