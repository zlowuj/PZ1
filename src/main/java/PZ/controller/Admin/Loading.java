package PZ.controller.Admin;
import javafx.application.Preloader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Loading extends Preloader{
    private static Stage mainStage;

    public static Stage getStage() {
        return mainStage;
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent loadingView = FXMLLoader.load(getClass().getResource("/Admin/Loading.fxml"));
        mainStage = stage;
        mainStage.setScene(new Scene(loadingView));
        mainStage.setTitle("Wczytywanie aplikacji");
        mainStage.centerOnScreen();
        mainStage.show();
    }
}
