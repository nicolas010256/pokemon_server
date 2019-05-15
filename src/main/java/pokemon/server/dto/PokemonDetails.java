package pokemon.server.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.beans.factory.annotation.Value;


public interface PokemonDetails {

    @Value("#{target.id}")
    Integer getId();

    @JsonProperty("pokedex_id")
    Integer getPokedexId();
    String getName();

    @JsonProperty("stats")
    StatsSumary getStats();

    List<TypeSumary> getTypes();
    List<MoveSummary> getMoves();
    List<AbilitySummary> getAbilities();
    String getSprite();


    interface TypeSumary {
        Integer getId();
        String getName();
    }

    interface StatsSumary {
        
        Integer getHp();
        Integer getAtk();
        Integer getDef();

        @JsonProperty("sp_atk")
        Integer getSpAtk();

        @JsonProperty("sp_def")
        Integer getSpDef();

        Integer getSpeed(); 
    }

    interface MoveSummary {
        Integer getId();
        String getName();
    }

    interface AbilitySummary {
        Integer getId();
        String getName();
    }
}