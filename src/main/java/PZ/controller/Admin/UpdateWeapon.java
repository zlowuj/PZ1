package PZ.controller.Admin;

import PZ.model.Character;
import PZ.model.Weapon;
import PZ.utils.DBUtil;
import PZ.utils.Validation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class UpdateWeapon extends Controller{
    @FXML
    private TextField nameTextField;
    @FXML private TextField attack_speed;
    @FXML private TextField attack_damage;
    @FXML private TextField ability_power;
    @FXML private TextField crit_chance;
    @FXML private TextField cooldown_reduction;
    @FXML private TextField mana;
    @FXML private TextField mana_regen;
    private Weapon weapon;
    public void changeSceneToWeaponMain(ActionEvent event) {
        changeScene(event, "/Admin/Weapons");
    }
    public Weapon getWeapon() {
        return (Weapon) DBUtil.selectAllWhere("Weapon", "name", name).get(0);
    }
    public void initialize() {
        weapon = getWeapon();
        nameTextField.setText(weapon.getName());
        attack_speed.setText(weapon.getAttack_speed());
        attack_damage.setText(weapon.getAttack_damage());
        ability_power.setText(weapon.getAbility_power());
        crit_chance.setText(weapon.getCrit_chance());
        cooldown_reduction.setText(weapon.getCooldown_reduction());
        mana.setText(weapon.getMana());
        mana_regen.setText(weapon.getMana_regen());
    }
    public void updateWeapon(ActionEvent event) {
        weapon.setName(nameTextField.getText());
        weapon.setAttack_speed(attack_speed.getText());
        weapon.setAttack_damage(attack_damage.getText());
        weapon.setAbility_power(ability_power.getText());
        weapon.setCrit_chance(crit_chance.getText());
        weapon.setCooldown_reduction(cooldown_reduction.getText());
        weapon.setMana(mana.getText());
        weapon.setMana_regen(mana_regen.getText());
        validateAndGoBack(event);
    }
    public void validateAndGoBack(ActionEvent event) {
        String errorMsg = Validation.validateNewWeapon(nameTextField.getText(),
                attack_speed.getText(),
                attack_damage.getText(),
                ability_power.getText(),
                crit_chance.getText(),
                cooldown_reduction.getText(),
                mana_regen.getText(),
                mana.getText());
        if(!errorMsg.isEmpty()) {
            error(errorMsg);
            return;
        }
        Weapon weapon = new Weapon(
                nameTextField.getText(),
                attack_speed.getText(),
                attack_damage.getText(),
                ability_power.getText(),
                crit_chance.getText(),
                cooldown_reduction.getText(),
                mana_regen.getText(),
                mana.getText()
        );
        try {
            DBUtil.update(weapon);
            changeSceneToWeaponMain(event);
        } catch (Exception e) {
            error("Ten login jest już zajęty");
        }
    }
}
