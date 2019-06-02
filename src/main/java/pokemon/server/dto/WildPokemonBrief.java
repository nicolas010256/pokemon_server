package pokemon.server.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WildPokemonBrief {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("pokedex_id")
    private Integer pokedexId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("sprite")
    private String sprite;

    @JsonProperty("types")
    private List<Type> types;

    public static class Type {
        
        @JsonProperty("id")
        private Integer id;
        
        @JsonProperty("name")
        private String name;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPokedexId() {
        return pokedexId;
    }

    public void setPokedexId(Integer pokedexId) {
        this.pokedexId = pokedexId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSprite() {
        return sprite;
    }

    public void setSprite(String sprite) {
        this.sprite = sprite;
    }

    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) {
        this.types = types;
    }
}