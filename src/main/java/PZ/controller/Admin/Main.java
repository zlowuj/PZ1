package PZ.controller.Admin;
import PZ.model.Character;
import PZ.utils.DBUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import java.util.List;
import java.util.Optional;
import PZ.controller.Admin.UpdateCharacter;

public class Main extends Controller{
    @FXML private ListView<String> listView;
    private Character character;
    public void changeSceneToCharactersManagement(ActionEvent event) {
        changeScene(event, "/Admin/AddCharacter");
    }
    public void changeSceneToCharacterUpdate(ActionEvent event) {
        if (listView.getSelectionModel().getSelectedIndex() == -1) {
            error("Nie wybrano żadnej postaci");
        } else {
            name = listView.getSelectionModel().getSelectedItem();
            changeScene(event, "/Admin/UpdateCharacter");
        }
    }
    public void deleteCharacter(ActionEvent event) {
        if (listView.getSelectionModel().getSelectedIndex() == -1) {
            error("Nie wybrano żadnej postaci");
        } else {
            name = listView.getSelectionModel().getSelectedItem();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("OSTRZEŻENIE");
            alert.setHeaderText("Czy na pewno chcesz usunąć tą postać?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                character =(Character)DBUtil.selectAllWhere("Character", "name", name).get(0);
                try {
                    DBUtil.delete(character);
                    changeScene(event, "/Admin/Main");
                } catch (Exception e) {
                    e.printStackTrace();
                    error("USUWANIE NIE POWIODŁO SIĘ");
                }
            }
        }
    }

    public void initialize() {
        name=null;
        List<Character> characters = DBUtil.selectAll("Character");
        characters.forEach(character -> listView.getItems().add(character.getName()));
    }
}
