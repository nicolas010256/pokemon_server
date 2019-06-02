package pokemon.server.persistence.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TEAM")
public class Team {

    @EmbeddedId
    private Id id = new Id();

    @Column(name = "NAME")
    private String name;

    @OneToMany
    private List<Pokemon> pokemon = new ArrayList<Pokemon>();

    @Embeddable
    public static class Id implements Serializable {
        private static final long serialVersionUID = -3515419503989928454L;

        @Column(name = "ID")
        private Integer teamId;

        @Column(name = "USERNAME")
        private String username;

        public Id() {}

        public Id(Integer teamId, String username) {
            this.teamId = teamId;
            this.username = username;
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