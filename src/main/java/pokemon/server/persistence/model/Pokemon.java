package pokemon.server.persistence.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "POKEMON")
public class Pokemon {
    @EmbeddedId
    private Id id = new Id();

    @Column(name = "NICKNAME")
    private String nickname;

    @OneToOne
    @JoinColumn(name = "WILD_POKEMON_ID", referencedColumnName = "ID")
    private WildPokemon wildPokemon;

    @OneToOne
    @JoinColumn(name = "ABILITY_ID", referencedColumnName = "ID")
    private Ability ability;

    @OneToOne
    @JoinColumn(name = "ITEM_ID", referencedColumnName = "ID")
    private Item item;

    @OneToOne
    @JoinColumn(name = "NATURE_ID", referencedColumnName = "ID")
    private Nature nature;

    @ManyToMany
    @JoinTable(name = "POKEMON_MOVE", joinColumns = {
        @JoinColumn(name = "TEAM_ID"), @JoinColumn(name = "POKEMON_ID"), @JoinColumn(name = "USERNAME")},
        inverseJoinColumns = {@JoinColumn(name = "MOVE_ID")})
    private List<Move> moves = new ArrayList<Move>();

    @AttributeOverrides({
        @AttributeOverride(name = "hp", column = @Column(name = "HP_IV")),
        @AttributeOverride(name = "atk", column = @Column(name = "ATK_IV")),
        @AttributeOverride(name = "def", column = @Column(name = "DEF_IV")),
        @AttributeOverride(name = "spAtk", column = @Column(name = "SP_ATK_IV")),
        @AttributeOverride(name = "spDef", column = @Column(name = "SP_DEF_IV")),
        @AttributeOverride(name = "speed", column = @Column(name = "SPEED_IV"))
    })
    @Embedded
    private Stats ivs;
     
    @AttributeOverrides({
        @AttributeOverride(name = "hp", column = @Column(name = "HP_EV")),
        @AttributeOverride(name = "atk", column = @Column(name = "ATK_EV")),
        @AttributeOverride(name = "def", column = @Column(name = "DEF_EV")),
        @AttributeOverride(name = "spAtk", column = @Column(name = "SP_ATK_EV")),
        @AttributeOverride(name = "spDef", column = @Column(name = "SP_DEF_EV")),
        @AttributeOverride(name = "speed", column = @Column(name = "SPEED_EV"))
    })
    @Embedded
    private Stats evs;
    
    @Embeddable
    public static class Id implements Serializable{
        private static final long serialVersionUID = 3862812951764185443L;

        @Column(name = "ID")
        private Integer teamPokemonId;

        @Column(name = "TEAM_ID")
        private Integer teamId;

        @Column(name = "USERNAME")
        private String username;

        public Id() {}

        public Id(Integer teamPokemonId, Integer teamId, String username) {
            this.teamPokemonId = teamPokemonId;
            this.teamId = teamId;
            this.username = username;
        }

        public Integer getTeamPokemonId() {
            return teamPokemonId;
        }

        public Integer getTeamId() {
            return teamId;
        }

        public String getUsername() {
            return username;
        }

    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Ability getAbility() {
        return ability;
    }

    public void setAbility(Ability ability) {
        this.ability = ability;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
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

    public WildPokemon getWildPokemon() {
        return wildPokemon;
    }

    public void setWildPokemon(WildPokemon wildPokemon) {
        this.wildPokemon = wildPokemon;
    }
    
}