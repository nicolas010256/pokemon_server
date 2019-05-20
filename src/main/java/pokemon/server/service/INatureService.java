package pokemon.server.service;

import java.util.List;

import pokemon.server.persistence.model.Nature;

public interface INatureService {

    List<Nature> findAll();

    Nature findById(Integer id);
}