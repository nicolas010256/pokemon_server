package pokemon.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pokemon.server.persistence.dao.NatureRepository;
import pokemon.server.persistence.model.Nature;

@Service
public class NatureService implements INatureService {

    @Autowired
    private NatureRepository repository;

    @Override
    public List<Nature> findAll() {
        return repository.findAll();
    }

    @Override
    public Nature findById(Integer id) {
        return repository.findById(id).get();
    }

}