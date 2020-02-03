package PZ.controller.Admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class Controller {
    protected static String name;
    protected void changeScene(ActionEvent event, String viewName) {
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        viewName = viewName + ".fxml";
        Parent newView;
        try {
            newView = FXMLLoader.load(getClass().getResource(viewName));
            window.setScene(new Scene(newView));
            window.show();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Nie udalo sie zaladowac widoku: " + viewName);
        }
    }
    protected void error(String message)
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Wystąpił błąd!");
        alert.setHeaderText(message);
        alert.setContentText(null);
        alert.showAndWait();
    }

}
