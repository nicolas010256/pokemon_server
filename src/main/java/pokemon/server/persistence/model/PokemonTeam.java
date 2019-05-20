package pokemon.server.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "")
public class PokemonTeam {

    @Id
    @Column(name = "ID")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "POKEMON_ID", referencedColumnName = "ID")
    private Pokemon pokemon;

    @Column(name = "NICKNAME")
    private String nickname;

    @OneToOne
    @JoinColumn(name = "ABILITY_ID", referencedColumnName = "ID")
    private Ability ability;

    @OneToOne
    @JoinColumn(name = "ITEM_ID", referencedColumnName = "ID")
    private Item item;

}