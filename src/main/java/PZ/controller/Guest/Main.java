package PZ.controller.Guest;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import PZ.controller.Admin.Controller;
import PZ.utils.DBUtil;
import PZ.model.Character;
public class Main extends Controller {
    @FXML private ListView<String> listView;
    public void changeSceneToLogIn(ActionEvent event) {
        changeScene(event, "/Guest/Login");
    }
    //public void register()
    public void changeSceneToCharacter(ActionEvent event) {
        if (listView.getSelectionModel().getSelectedIndex() == -1) {
            error("Nie wybrano żadnej postaci");
        } else {
            name = listView.getSelectionModel().getSelectedItem();
            changeScene(event, "/Guest/CharacterSheet");
        }
    }
    public void changeSceneToRegister(ActionEvent event) {
        changeScene(event, "/Guest/Register");
    }
}
