package pokemon.server.persistence.model;

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
@Table(name = "WILD_POKEMON")
public class WildPokemon {

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
    @JoinTable(name = "WILD_POKEMON_ABILITY", joinColumns = {@JoinColumn(name = "WILD_POKEMON_ID")}, inverseJoinColumns = {
        @JoinColumn(name = "ABILITY_ID")})
    private List<Ability> abilities = new ArrayList<Ability>();

    @ManyToMany
    @JoinTable(name = "WILD_POKEMON_TYPE", joinColumns = {@JoinColumn(name = "WILD_POKEMON_ID")}, inverseJoinColumns = {
        @JoinColumn(name = "TYPE_ID")})
    private List<Type> types = new ArrayList<Type>();

    @ManyToMany
    @JoinTable(name = "WILD_POKEMON_MOVE", joinColumns = {@JoinColumn(name = "WILD_POKEMON_ID")}, inverseJoinColumns = {
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
    public List<Type> getTypes() {
        return types;
    }

    /**
     * @param type the type to set
     */
    public void setTypes(List<Type> type) {
        this.types = type;
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