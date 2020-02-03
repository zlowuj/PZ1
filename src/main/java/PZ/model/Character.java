package PZ.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@Entity
@Table (name = "characters")
public class Character implements Serializable{
    @Id
    @Column (name = "name")
    private String name;
    @Column (name = "description")
    private String description;
    @Column (name = "passive_ability")
    private String passive_ability;
    @Column (name = "q_ability")
    private String q_ability;
    @Column (name = "w_ability")
    private String w_ability;
    @Column (name = "e_ability")
    private String e_ability;
    @Column (name = "r_ability")
    private String r_ability;
    public Character(String name, String description, String passive_ability, String q_ability, String w_ability, String e_ability, String r_ability) {
        this.name=name;
        this.description=description;
        this.passive_ability=passive_ability;
        this.q_ability=q_ability;
        this.w_ability=w_ability;
        this.e_ability=e_ability;
        this.r_ability=r_ability;
    }
    public Character () {}
    public String getName () {
        return this.name;
    }
    public String getDescription () {
        return description;
    }
    public String getPassive_ability () {
        return passive_ability;
    }
    public String getQ_ability () {
        return q_ability;
    }
    public String getW_ability () {
        return w_ability;
    }
    public String getE_ability () {
        return e_ability;
    }
    public String getR_ability () {
        return r_ability;
    }

    public void setName (String name) {
        this.name=name;
    }
    public void setDescription (String description) {
        this.description=description;
    }
    public void setPassive_ability (String passive_ability) {
        this.passive_ability=passive_ability;
    }
    public void setQ_ability (String q_ability) {
        this.q_ability=q_ability;
    }
    public void setW_ability (String w_ability) {
        this.w_ability=w_ability;
    }
    public void setE_ability (String e_ability) {
        this.e_ability=e_ability;
    }
    public void setR_ability (String r_ability) {
        this.r_ability=r_ability;
    }

}
