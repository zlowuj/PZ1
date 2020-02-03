package PZ.controller.Admin;

import PZ.model.Character;
import PZ.model.Weapon;
import PZ.utils.DBUtil;
import PZ.utils.Validation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.List;
import java.util.Random;

public class RandomBuild extends Controller{
    @FXML private ListView<String> listView;
    public void changeSceneToAdminMain(ActionEvent event) {
        changeScene(event, "/Admin/Main");
    }
    public void initialize(){
        List<Character> characters = DBUtil.selectAll("Character");
        Character character = new Character();
        List<Weapon> weapons = DBUtil.selectAll("Weapon");
        Random generator = new Random();
        int number = generator.nextInt(characters.size());
        character = characters.get(number);
        listView.getItems().add(character.getName());
        for(int i=0; i<6; i++) {
            Weapon weapon = new Weapon();
            number=generator.nextInt(weapons.size());
            weapon = weapons.get(number);
            listView.getItems().add(weapon.getName());
        }
    }
}
