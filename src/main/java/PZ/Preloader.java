package PZ;
import javafx.application.Application;
import PZ.controller.Admin.Loading;
public class Preloader {
    public static void main(String[] args) {
        System.setProperty("javafx.preloader", Loading.class.getName());
        Application.launch(App.class, args);
    }
}
