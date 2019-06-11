package pokemon.server.service;

import org.springframework.data.domain.Page;

import pokemon.server.exception.ResourceNotFoundException;
import pokemon.server.persistence.model.Nature;

public interface INatureService {

    Page<Nature> findAll(int page, int size) throws ResourceNotFoundException;

    Nature findById(Integer id) throws ResourceNotFoundException;
}