package PZ.controller.Admin;

import PZ.model.Character;
import PZ.model.Weapon;
import PZ.utils.DBUtil;
import PZ.utils.Validation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AddWeapon extends Controller{
    @FXML private TextField name;
    @FXML private TextField attack_speed;
    @FXML private TextField attack_damage;
    @FXML private TextField ability_power;
    @FXML private TextField crit_chance;
    @FXML private TextField cooldown_reduction;
    @FXML private TextField mana;
    @FXML private TextField mana_regen;
    public void changeSceneToWeaponMain(ActionEvent event) {
        changeScene(event, "/Admin/Weapons");
    }
    public void addWeapon(ActionEvent event) {
        String errorMsg = Validation.validateNewWeapon(name.getText(),
                attack_speed.getText(),
                attack_damage.getText(),
                ability_power.getText(),
                crit_chance.getText(),
                cooldown_reduction.getText(),
                mana.getText(),
                mana_regen.getText());
        if(!errorMsg.isEmpty()) {
            error(errorMsg);
            return;
        }
        Weapon weapon = new Weapon(
                name.getText(),
                attack_speed.getText(),
                attack_damage.getText(),
                ability_power.getText(),
                crit_chance.getText(),
                cooldown_reduction.getText(),
                mana.getText(),
                mana_regen.getText()
        );
        try {
            DBUtil.insert(weapon);
            changeSceneToWeaponMain(event);
        } catch (Exception e) {
            error("Ta nazwa jest już zajęta!");
        }
    }
}
