package PZ.controller.Admin;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import PZ.model.Character;
import PZ.utils.DBUtil;
import PZ.utils.Validation;

public class UpdateCharacter extends Controller{
    @FXML private TextField nameTextField;
    @FXML private TextField description;
    @FXML private TextField passive_ability;
    @FXML private TextField q_ability;
    @FXML private TextField w_ability;
    @FXML private TextField e_ability;
    @FXML private TextField r_ability;
    private Character character;
    public void changeSceneToAdminMain(ActionEvent event) {
        changeScene(event, "/Admin/Main");
    }
    public void initialize() {
        character = getCharacter();
        nameTextField.setText(character.getName());
        description.setText(character.getDescription());
        passive_ability.setText(character.getPassive_ability());
        q_ability.setText(character.getQ_ability());
        w_ability.setText(character.getW_ability());
        e_ability.setText(character.getE_ability());
        r_ability.setText(character.getR_ability());
    }
    public Character getCharacter() {
        return (Character)DBUtil.selectAllWhere("Character", "name", name).get(0);
    }
    public void updateCharacter(ActionEvent event) {
        character.setName(nameTextField.getText());
        character.setDescription(description.getText());
        character.setPassive_ability(passive_ability.getText());
        character.setQ_ability(q_ability.getText());
        character.setW_ability(w_ability.getText());
        character.setE_ability(e_ability.getText());
        character.setR_ability(r_ability.getText());
        validateAndGoBack(event);
    }
    public void validateAndGoBack(ActionEvent event) {
        String errorMsg = Validation.validateNewCharacter(nameTextField.getText(),
                description.getText(),
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
                nameTextField.getText(),
                description.getText(),
                passive_ability.getText(),
                q_ability.getText(),
                w_ability.getText(),
                e_ability.getText(),
                r_ability.getText()
        );
        try {
            DBUtil.update(character);
            changeSceneToAdminMain(event);
        } catch (Exception e) {
            error("Ten login jest już zajęty");
        }
    }
}
