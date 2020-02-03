package PZ.controller.Guest;

import PZ.controller.Admin.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import PZ.utils.DBUtil;
public class Login extends Controller {
    @FXML private TextField username;
    @FXML private TextField password;
    Character character_username, character_password;

    public void ValidateAndChangeSceneToAdmin(ActionEvent event) {
        character_username = (Character) DBUtil.selectAllWhere("Account", "username", username.getText()).get(0);
        character_password = (Character) DBUtil.selectAllWhere("Account", "password", password.getText()).get(0);
        if(character_username==character_password) {
            changeScene(event, "/Admin/Main");
        } else {
            error("Zły login lub hasło");
        }
    }
    public void changeSceneToGuestMain(ActionEvent event) {
        changeScene(event, "/Guest/Main");
    }
}
