package pokemon.server.persistence.model;

import java.io.Serializable;
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
@Table(name = "TEAM_POKEMON")
public class TeamPokemon {
    @EmbeddedId
    private Id id = new Id();

    @Column(name = "NICKNAME")
    private String nickname;

    @OneToOne
    @JoinColumn(name = "POKEMON_ID", referencedColumnName = "ID")
    private Pokemon pokemon;

    @OneToOne
    @JoinColumn(name = "ABILITY_ID", referencedColumnName = "ID")
    private Ability ability;

    @OneToOne
    @JoinColumn(name = "ITEM_ID", referencedColumnName = "ID")
    private Item item;

    @ManyToMany
    @JoinTable(name = "POKEMON_TAEM_MOVE", joinColumns = {
        @JoinColumn(name = "POKEMON_TEAM_ID"), @JoinColumn(name = "USERNAME"), @JoinColumn(name = "TEAM_ID")},
        inverseJoinColumns = {@JoinColumn(name = "MOVE_ID")})
    private List<Move> moves;

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
    
}