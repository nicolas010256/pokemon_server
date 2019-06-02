package pokemon.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import pokemon.server.persistence.dao.NatureRepository;
import pokemon.server.persistence.model.Nature;

@Service
public class NatureService implements INatureService {

    @Autowired
    private NatureRepository repository;

    @Override
    public Page<Nature> findAll(int page, int size) {
        return repository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Nature findById(Integer id) {
        return repository.findById(id).get();
    }

}