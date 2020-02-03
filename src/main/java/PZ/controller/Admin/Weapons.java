package PZ.controller.Admin;

import PZ.model.Character;
import PZ.model.Weapon;
import PZ.utils.DBUtil;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import java.util.List;
import java.util.Optional;
import PZ.controller.Admin.UpdateCharacter;

public class Weapons extends Controller{
    @FXML private ListView<String> listView;
    private Weapon weapon;
    public void changeSceneToWeaponsManagement(ActionEvent event) {
        changeScene(event, "/Admin/AddWeapon");
    }
    public void changeSceneToWeaponsUpdate(ActionEvent event) {
        if (listView.getSelectionModel().getSelectedIndex() == -1) {
            error("Nie wybrano żadnego przedmiotu");
        } else {
            name = listView.getSelectionModel().getSelectedItem();
            changeScene(event, "/Admin/UpdateWeapon");
        };}
    public void deleteWeapon(ActionEvent event){
        if (listView.getSelectionModel().getSelectedIndex() == -1) {
            error("Nie wybrano żadnego przedmiotu");
        } else {
            name = listView.getSelectionModel().getSelectedItem();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("OSTRZEŻENIE");
            alert.setHeaderText("Czy na pewno chcesz usunąć ten przedmiot?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                 weapon=(Weapon) DBUtil.selectAllWhere("Weapon", "name", name).get(0);
                try {
                    DBUtil.delete(weapon);
                    changeScene(event, "/Admin/Weapons");
                } catch (Exception e) {
                    e.printStackTrace();
                    error("USUWANIE NIE POWIODŁO SIĘ");
                }
            }
        }
    }
    public void changeSceneToAdminMain(ActionEvent event) {
        changeScene(event, "/Admin/Main");
    }
    public void initialize() {
        name=null;
        Task<List<Weapon>> thread= new Task<List<Weapon>>() {

            @Override
            protected List<Weapon> call() throws Exception {
                return DBUtil.selectAll("Weapon");
            }
        };
        thread.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent workerStateEvent) {
                List<Weapon> weapons = thread.getValue();
                weapons.forEach(weapon -> listView.getItems().add(weapon.getName()));
            }
        });
        new Thread(thread).start();
        //List<Character> characters = DBUtil.selectAll("Character");
        //characters.forEach(character -> listView.getItems().add(character.getName()));
    }
}
