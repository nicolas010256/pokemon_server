package pokemon.server.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.beans.factory.annotation.Value;

public interface PokemonSimple {
    
    @Value("#{target.id}")
    Integer getId();

    @JsonProperty("pokedex_id")
    Integer getPokedexId();

    String getName();
    List<TypeSumary> getTypes();
    String getSprite();

    interface TypeSumary {
        Integer getId();
        String getName();
    }
    
}