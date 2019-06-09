package pokemon.server.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TeamDetailed {
    
    @JsonProperty("id")
    private Integer id;
    
    @JsonProperty("name")
    private String name;
    
    @JsonProperty("pokemon")
    private List<Pokemon> pokemon;
    
    public static class Pokemon {
        
        @JsonProperty("id")
        private Integer id;
        
        @JsonProperty("pokemon_id")
        private Integer pokemonId;
        
        @JsonProperty("name")
        private String name;
        
        @JsonProperty("sprite")
        private String sprite;
        
        @JsonProperty("stats")
        private Stats stats;
        
        @JsonProperty("ivs")
        private Stats ivs;
        
        @JsonProperty("evs")
        private Stats evs;
        
        @JsonProperty("ability")
        private Ability ability;
        
        @JsonProperty("moves")
        private List<Move> moves = new ArrayList<>();
        
        @JsonProperty("item")
        private Item item;
        
        @JsonProperty("nature")
        private Nature nature;
        
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

        public Nature getNature() {
            return nature;
        }

        public void setNature(Nature nature) {
            this.nature = nature;
        }
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
    
    public List<Pokemon> getPokemon() {
        return pokemon;
    }
    
    public void setPokemon(List<Pokemon> pokemon) {
        this.pokemon = pokemon;
    }
}