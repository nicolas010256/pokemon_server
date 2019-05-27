package pokemon.server.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Poke {
    @JsonProperty("pokemon_id")
    private Integer pokemonId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("ability_id")
    private Integer abilityId;

    @JsonProperty("nature_id")
    private Integer natureId;

    @JsonProperty("item_id")
    private Integer itemId;

    @JsonProperty("ivs")
    private Stats ivs;

    @JsonProperty("evs")
    private Stats evs;

    @JsonProperty("moves")
    private List<Integer> moves = new ArrayList<Integer>();

    public Integer getPokemonId() {
        return pokemonId;
    }

    public void setPokemonId(Integer id) {
        this.pokemonId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAbilityId() {
        return abilityId;
    }

    public void setAbilityId(Integer abilityId) {
        this.abilityId = abilityId;
    }

    public Integer getNatureId() {
        return natureId;
    }

    public void setNatureId(Integer natureId) {
        this.natureId = natureId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    
    public Stats getIvs() {
        return ivs;
    }

    public void setIvs(Stats ivs) {
        this.ivs = ivs;
    }

    public Stats getEvs() {
        return evs;
    }

    public void setEvs(Stats evs) {
        this.evs = evs;
    }

    public class Stats {
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

    public List<Integer> getMoves() {
        return moves;
    }

    public void setMoves(List<Integer> moves) {
        this.moves = moves;
    }
}