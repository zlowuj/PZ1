package PZ;

import PZ.controller.Admin.Loading;
import PZ.utils.DBUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    private static Scene scene;
    @Override
    public void init() {
        DBUtil.init();
    }
    @Override
    public void start(Stage mainStage) throws IOException {
        Parent mainView = FXMLLoader.load(getClass().getResource("/Admin/Main.fxml"));
        mainStage = Loading.getStage();
        mainStage.setScene(new Scene(mainView));
        mainStage.setTitle("LOL");
        mainStage.centerOnScreen();
        mainStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }

}