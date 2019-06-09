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

    @JsonProperty("stats")
    private Stats stats;

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

    public static class Stats {
        @JsonProperty("hp")
        private Integer hp;

        @JsonProperty("atk")
        private Integer atk;

        @JsonProperty("def")
        private Integer def;

        @JsonProperty("sp_atk")
        private Integer spAtk;

        @JsonProperty("sp_def")
        private Integer spDef;

        @JsonProperty("speed")
        private Integer speed;

        public Integer getHp() {
            return hp;
        }

        public void setHp(Integer hp) {
            this.hp = hp;
        }

        public Integer getAtk() {
            return atk;
        }

        public void setAtk(Integer atk) {
            this.atk = atk;
        }

        public Integer getDef() {
            return def;
        }

        public void setDef(Integer def) {
            this.def = def;
        }

        public Integer getSpAtk() {
            return spAtk;
        }

        public void setSpAtk(Integer spAtk) {
            this.spAtk = spAtk;
        }

        public Integer getSpDef() {
            return spDef;
        }

        public void setSpDef(Integer spDef) {
            this.spDef = spDef;
        }

        public Integer getSpeed() {
            return speed;
        }

        public void setSpeed(Integer speed) {
            this.speed = speed;
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

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }
}