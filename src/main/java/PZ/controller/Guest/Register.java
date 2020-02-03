package PZ.controller.Guest;

import PZ.controller.Admin.Controller;
import PZ.model.Account;
import javafx.fxml.FXML;
import javafx.scene.AccessibleAction;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import PZ.utils.DBUtil;
public class Register extends Controller {
    @FXML private TextField username;
    @FXML private TextField password1;
    @FXML private TextField password2;
    public void ValidateAndChangeSceneToAdmin(ActionEvent event) {
        if(password1.getText()==password2.getText()) {
            Account account = new Account();
            account.setUsername(username.getText());
            account.setPassword(password1.getText());
            try {
                DBUtil.insert(account);
            } catch (Exception e) {
                error("Ten username jest już przez kogoś zajęty");
            }
            changeScene(event, "/Admin/Main");
        } else {
            error("Hasła nie zgadzają się");
        }
    }
}
