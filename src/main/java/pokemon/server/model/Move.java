package pokemon.server.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "MOVE")
public class Move {
    
    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "POWER")
    private Integer power;

    @Column(name = "ACCURACY")
    private Integer accuracy;

    @Column(name = "PP")
    private Integer pp;

    @Column(name = "DAMAGE_CATEGORY")
    private String damageCategory;

    @ManyToOne
    @JoinColumn(name = "TYPE_ID")
    private Type type;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @return the type
     */
    public Type getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(Type type) {
        this.type = type;
    }

    /**
     * @return the pp
     */
    public Integer getPp() {
        return pp;
    }

    /**
     * @param pp the pp to set
     */
    public void setPp(Integer pp) {
        this.pp = pp;
    }

    /**
     * @return the damageCategory
     */
    public String getDamageCategory() {
        return damageCategory;
    }

    /**
     * @param damageCategory the damageCategory to set
     */
    public void setDamageCategory(String damageCategory) {
        this.damageCategory = damageCategory;
    }

    /**
     * @return the accuracy
     */
    public Integer getAccuracy() {
        return accuracy;
    }

    /**
     * @param accuracy the accuracy to set
     */
    public void setAccuracy(Integer accuracy) {
        this.accuracy = accuracy;
    }

    /**
     * @return the power
     */
    public Integer getPower() {
        return power;
    }

    /**
     * @param power the power to set
     */
    public void setPower(Integer power) {
        this.power = power;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
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