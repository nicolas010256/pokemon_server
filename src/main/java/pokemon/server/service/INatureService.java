package pokemon.server.service;

import org.springframework.data.domain.Page;

import pokemon.server.persistence.model.Nature;

public interface INatureService {

    Page<Nature> findAll(int page, int size);

    Nature findById(Integer id);
}