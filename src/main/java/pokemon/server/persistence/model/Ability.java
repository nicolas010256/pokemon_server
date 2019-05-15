package pokemon.server.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ABILITY")
public class Ability {

    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name= "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
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