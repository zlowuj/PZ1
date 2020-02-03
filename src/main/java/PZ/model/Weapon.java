package PZ.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "weapons")
public class Weapon implements Serializable {
    @Id
    @Column (name = "name")
    private String name;
    @Column (name = "attack_speed")
    private String attack_speed;
    @Column (name = "attack_damage")
    private String attack_damage;
    @Column (name = "ability_power")
    private String ability_power;
    @Column (name = "crit_chance")
    private String crit_chance;
    @Column (name = "cooldown_reduction")
    private String cooldown_reduction;
    @Column (name = "mana")
    private String mana;
    @Column (name = "mana_regen")
    private String mana_regen;
    public Weapon(String name, String attack_speed, String attack_damage,
                  String ability_power, String crit_chance, String cooldown_reduction,
                  String mana, String mana_regen) {
        this.name=name;
        this.attack_speed=attack_speed;
        this.attack_damage=attack_damage;
        this.ability_power=ability_power;
        this.crit_chance=crit_chance;
        this.cooldown_reduction=cooldown_reduction;
        this.mana=mana;
        this.mana_regen=mana_regen;
    }
    public Weapon() {
    }
    public String getName() {
        return this.name;
    }
    public String getAttack_speed() {
        return this.attack_speed;
    }
    public String getAttack_damage() {
        return attack_damage;
    }
    public String getAbility_power() {
        return ability_power;
    }
    public String getCrit_chance() {
        return crit_chance;
    }
    public String getCooldown_reduction() {
        return cooldown_reduction;
    }
    public String getMana() {
        return mana;
    }
    public String getMana_regen() {
        return mana_regen;
    }
    public void setName(String name) {
        this.name=name;
    }
    public void setAttack_speed(String attack_speed) {
        this.attack_speed=attack_speed;
    }
    public void setAttack_damage(String attack_damage) {
        this.attack_damage=attack_damage;
    }
    public void setAbility_power(String ability_power) {
        this.ability_power=ability_power;
    }
    public void setCrit_chance(String crit_chance) {
        this.crit_chance=crit_chance;
    }
    public void setCooldown_reduction(String cooldown_reduction) {
        this.cooldown_reduction=cooldown_reduction;
    }
    public void setMana(String mana) {
        this.mana=mana;
    }
    public void setMana_regen(String mana_regen) {
        this.mana_regen=mana_regen;
    }

}
