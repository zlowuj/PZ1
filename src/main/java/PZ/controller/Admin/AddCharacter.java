package PZ.controller.Admin;

import PZ.utils.Validation;
import javafx.event.ActionEvent;
import PZ.utils.DBUtil;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import PZ.model.Character;

public class AddCharacter extends Controller{
    @FXML private TextField name;
    @FXML private TextField desciption;
    @FXML private TextField passive_ability;
    @FXML private TextField q_ability;
    @FXML private TextField w_ability;
    @FXML private TextField e_ability;
    @FXML private TextField r_ability;
    public void changeSceneToAdminMain(ActionEvent event) {
        changeScene(event, "/Admin/Main");
    }
    public void addCharacter(ActionEvent event) {
        String errorMsg = Validation.validateNewCharacter(name.getText(),
                desciption.getText(),
                passive_ability.getText(),
                q_ability.getText(),
                w_ability.getText(),
                e_ability.getText(),
                r_ability.getText());
        if(!errorMsg.isEmpty()) {
            error(errorMsg);
            return;
        }
        Character character = new Character(
                name.getText(),
                desciption.getText(),
                passive_ability.getText(),
                q_ability.getText(),
                w_ability.getText(),
                e_ability.getText(),
                r_ability.getText()
        );
        try {
            DBUtil.insert(character);
            changeSceneToAdminMain(event);
        } catch (Exception e) {
            error("Ta nazwa jest już zajęta!");
        }
    }

}
