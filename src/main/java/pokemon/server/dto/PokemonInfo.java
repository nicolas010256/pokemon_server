package pokemon.server.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PokemonInfo {
    private Integer id;
    @JsonProperty("pokemon_id")
    private Integer pokemonId;
    private String nickname;
    private Stats stats;
    private Stats ivs;
    private Stats evs;
    private Nature nature;
    private Ability ability;
    @JsonProperty("moves")
    private Collection<Move> moves = new ArrayList<Move>();
    private String sprite;
    private Item item;

    public PokemonInfo() {}

    public PokemonInfo(Integer id, Integer pokemonId, String nickname, Stats stats, Stats ivs,Stats evs,
             Nature nature, Ability ability, List<Move> moves, String sprite, Item item) {

        this.id = id;
        this.nickname = nickname;
        this.stats = stats;
        this.ivs = ivs;
        this.evs = evs;
        this.nature = nature;
        this.ability = ability;
        this.moves = moves;
        this.sprite = sprite;
        this.item = item;
    }
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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

    public Collection<Move> getMoves() {
        return moves;
    }

    public void setMoves(Collection<Move> moves) {
        this.moves = moves;
    }

    public String getSprite() {
        return sprite;
    }

    public void setSprite(String sprite) {
        this.sprite = sprite;
    }

    public Integer getPokemonId() {
        return pokemonId;
    }

    public void setPokemonId(Integer pokemonId) {
        this.pokemonId = pokemonId;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public static class Stats {
        private int hp;
        private int atk;
        private int def;
        @JsonProperty("sp_atk")
        private int spAtk;
        @JsonProperty("sp_def")
        private int spDef;
        private int speed;

        public Stats() {}

        public Stats(int hp, int atk, int def, int spAtk, int spDef, int speed) {
            this.hp = hp;
            this.atk = atk;
            this.def = def;
            this.spAtk = spAtk;
            this.spDef = spDef;
            this.speed = speed;
        }

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
        private Integer id;
        private String name;

        public Nature() {}

        public Nature(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

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
        private Integer id;
        private String name;

        public Ability() {}

        public Ability(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

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
        private Integer id;
        private String name;

        public Move() {}

        public Move(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

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
        private Integer id;
        private String name;

        public Item() {}

        public Item(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

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

}