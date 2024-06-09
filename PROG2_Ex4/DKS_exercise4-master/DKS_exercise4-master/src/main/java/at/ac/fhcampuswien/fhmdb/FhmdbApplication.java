package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.factoryPattern.MyFactory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;



public class FhmdbApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Create an instance of MyFactory
            MyFactory myFactory = new MyFactory();

            // Configure FXMLLoader to use MyFactory
            FXMLLoader loader = new FXMLLoader(getClass().getResource("home.fxml"));
            loader.setControllerFactory(myFactory);

            // Load the FXML file and get the root node
            Parent root = loader.load();

            // Set up the scene with the root node
            Scene scene = new Scene(root);

            // Configure the primary stage
            primaryStage.setScene(scene);
            primaryStage.setTitle("FHMDb");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}