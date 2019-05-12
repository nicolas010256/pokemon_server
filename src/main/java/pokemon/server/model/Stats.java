package pokemon.server.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Stats {

    @Column(name = "HP")
    private Integer hp;

    @Column(name = "ATK")
    private Integer atk;

    @Column(name = "DEF")
    private Integer def;

    @Column(name = "SP_ATK")
    private Integer spAtk;

    @Column(name = "SP_DEF")
    private Integer spDef;

    @Column(name = "SPEED")
    private Integer speed;

    /**
     * @return the hp
     */
    public Integer getHp() {
        return hp;
    }

    /**
     * @return the speed
     */
    public Integer getSpeed() {
        return speed;
    }

    /**
     * @param speed the speed to set
     */
    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    /**
     * @return the spDef
     */
    public Integer getSpDef() {
        return spDef;
    }

    /**
     * @param spDef the spDef to set
     */
    public void setSpDef(Integer spDef) {
        this.spDef = spDef;
    }

    /**
     * @return the spAtk
     */
    public Integer getSpAtk() {
        return spAtk;
    }

    /**
     * @param spAtk the spAtk to set
     */
    public void setSpAtk(Integer spAtk) {
        this.spAtk = spAtk;
    }

    /**
     * @return the def
     */
    public Integer getDef() {
        return def;
    }

    /**
     * @param def the def to set
     */
    public void setDef(Integer def) {
        this.def = def;
    }

    /**
     * @return the atk
     */
    public Integer getAtk() {
        return atk;
    }

    /**
     * @param atk the atk to set
     */
    public void setAtk(Integer atk) {
        this.atk = atk;
    }

    /**
     * @param hp the hp to set
     */
    public void setHp(Integer hp) {
        this.hp = hp;
    }
}