package pokemon.server.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WildPokemonDetailed {
    
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("pokedex_id")
    private Integer pokedexId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("stats")
    private Stats stats;

    @JsonProperty("types")
    private List<Type> types;

    @JsonProperty("abilities")
    private List<Ability> abilities;

    @JsonProperty("moves")
    private List<Move> moves;

    @JsonProperty("sprite")
    private String sprite;

    public static class Stats {

        @JsonProperty("hp")
        private int hp;

        @JsonProperty("atk")
        private int atk;

        @JsonProperty("def")
        private int def;

        @JsonProperty("sp_atk")
        private int spAtk;

        @JsonProperty("sp_def")
        private int spDef;

        @JsonProperty("speed")
        private int speed;

        public int getHp() {
            return hp;
        }

        public void setHp(int hp) {
            this.hp = hp;
        }

        public int getAtk() {
            return atk;
        }

        public void setAtk(int atk) {
            this.atk = atk;
        }

        public int getDef() {
            return def;
        }

        public void setDef(int def) {
            this.def = def;
        }

        public int getSpAtk() {
            return spAtk;
        }

        public void setSpAtk(int spAtk) {
            this.spAtk = spAtk;
        }

        public int getSpDef() {
            return spDef;
        }

        public void setSpDef(int spDef) {
            this.spDef = spDef;
        }

        public int getSpeed() {
            return speed;
        }

        public void setSpeed(int speed) {
            this.speed = speed;
        }
    }

    public static class Type {

        @JsonProperty("id")
        private int id;

        @JsonProperty("name")
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class Ability {

        @JsonProperty("id")
        private int id;

        @JsonProperty("name")
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class Move {

        @JsonProperty("id")
        private int id;

        @JsonProperty("name")
        private String name;

        @JsonProperty("type")
        private String type;

        @JsonProperty("power")
        private Integer power;
        
        @JsonProperty("accuracy")
        private Integer accuracy;

        @JsonProperty("damage_category")
        private String damageCategory;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Integer getPower() {
            return power;
        }

        public void setPower(Integer power) {
            this.power = power;
        }

        public Integer getAccuracy() {
            return accuracy;
        }

        public void setAccuracy(Integer accuracy) {
            this.accuracy = accuracy;
        }

        public String getDamageCategory() {
            return damageCategory;
        }

        public void setDamageCategory(String damageCategory) {
            this.damageCategory = damageCategory;
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

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) {
        this.types = types;
    }

    public List<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public String getSprite() {
        return sprite;
    }

    public void setSprite(String sprite) {
        this.sprite = sprite;
    }
}