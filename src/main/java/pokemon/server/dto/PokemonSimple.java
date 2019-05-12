package pokemon.server.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.beans.factory.annotation.Value;

import pokemon.server.model.Type;

public interface PokemonSimple {
    
    @Value("#{target.id}")
    Integer getId();

    @JsonProperty("pokedex_id")
    Integer getPokedexId();

    String getName();
    List<Type> getTypes();
    String getSprite();
    
}