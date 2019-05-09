package pokemon.server.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "POKEMON")
public class Pokemon {

    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "POKEDEX_ID")
    private Integer pokedexId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "IS_DEFAULT")
    private boolean isDefault;

    @Embedded
    private Stats stats;

    @ManyToMany
    @JoinTable(name = "POKEMON_ABILITY", joinColumns = {@JoinColumn(name = "POKEMON_ID")}, inverseJoinColumns = {
        @JoinColumn(name = "ABILITY_ID")})
    private List<Ability> abilities = new ArrayList<Ability>();

    @ManyToMany
    @JoinTable(name = "POKEMON_TYPE", joinColumns = {@JoinColumn(name = "POKEMON_ID")}, inverseJoinColumns = {
        @JoinColumn(name = "TYPE_ID")})
    private List<Type> type = new ArrayList<Type>();

    @ManyToMany
    @JoinTable(name = "POKEMON_MOVE", joinColumns = {@JoinColumn(name = "POKEMON_ID")}, inverseJoinColumns = {
        @JoinColumn(name = "MOVE_ID")})
    private List<Move> moves = new ArrayList<Move>();

    @Column(name = "SPRITE")
    private String sprite;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @return the moves
     */
    public List<Move> getMoves() {
        return moves;
    }

    /**
     * @param moves the moves to set
     */
    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    /**
     * @return the abilities
     */
    public List<Ability> getAbilities() {
        return abilities;
    }

    /**
     * @param abilities the abilities to set
     */
    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }

    /**
     * @return the stats
     */
    public Stats getStats() {
        return stats;
    }

    /**
     * @param stats the stats to set
     */
    public void setStats(Stats stats) {
        this.stats = stats;
    }

    /**
     * @return the isDefault
     */
    public boolean isDefault() {
        return isDefault;
    }

    /**
     * @param isDefault the isDefault to set
     */
    public void setDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

    /**
     * @return the pokedexId
     */
    public Integer getPokedexId() {
        return pokedexId;
    }

    /**
     * @param pokedexId the pokedexId to set
     */
    public void setPokedexId(Integer pokedexId) {
        this.pokedexId = pokedexId;
    }

    /**
     * @return the sprite
     */
    public String getSprite() {
        return sprite;
    }

    /**
     * @param sprite the sprite to set
     */
    public void setSprite(String sprite) {
        this.sprite = sprite;
    }

    /**
     * @return the type
     */
    public List<Type> getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(List<Type> type) {
        this.type = type;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }
}