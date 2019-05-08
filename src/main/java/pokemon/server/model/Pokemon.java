package pokemon.server.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "POKEMON")
public class Pokemon {

    @Id
    @Column(name = "ID")
    private Integer id;

    @JsonProperty("pokedex_id")
    @Column(name = "POKEDEX_ID")
    private Integer pokedexId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "IS_DEFAULT")
    private Boolean isDefault;

    @JsonProperty("types")
    @ManyToMany
    @JoinTable(name = "POKEMON_TYPE", joinColumns = { @JoinColumn(name = "POKEMON_ID") }, inverseJoinColumns = {
            @JoinColumn(name = "TYPE_ID") })
    private List<Type> type = new ArrayList<Type>();

    @Column(name = "SPRITE")
    private String sprite;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @return the isDefault
     */
    public Boolean getIsDefault() {
        return isDefault;
    }

    /**
     * @param isDefault the isDefault to set
     */
    public void setIsDefault(Boolean isDefault) {
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