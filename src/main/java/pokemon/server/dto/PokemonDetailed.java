package pokemon.server.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PokemonDetailed {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("pokemon_id")
    private Integer wildPokemonId;
    
    @JsonProperty("name")
    private String name;

    @JsonProperty("stats")
    private Stats stats;

    @JsonProperty("ivs")
    private Stats ivs;

    @JsonProperty("evs")
    private Stats evs;

    @JsonProperty("nature")
    private Nature nature;

    @JsonProperty("ability")
    private Ability ability;

    @JsonProperty("moves")
    private List<Move> moves;

    @JsonProperty("item")
    private Item item;

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

    public static class Nature {
        
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

    public static class Ability {

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

    public static class Move {

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

    public static class Item {
        
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

    public Integer getWildPokemonId() {
        return wildPokemonId;
    }

    public void setWildPokemonId(Integer wildPokemonId) {
        this.wildPokemonId = wildPokemonId;
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

    public Nature getNature() {
        return nature;
    }

    public void setNature(Nature nature) {
        this.nature = nature;
    }

    public Ability getAbility() {
        return ability;
    }

    public void setAbility(Ability ability) {
        this.ability = ability;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getSprite() {
        return sprite;
    }

    public void setSprite(String sprite) {
        this.sprite = sprite;
    }
}