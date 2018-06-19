//package main.java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {


        @Override
        public void start(Stage primaryStage) throws Exception{
            AnchorPane root = FXMLLoader.load(getClass().getResource("/fxml/GUI.fxml"));
            primaryStage.setTitle("Jar Analyzer");
            primaryStage.getIcons().add(new Image("/images/iconJar.png"));
            primaryStage.setScene(new Scene(root, 1010, 600));
            primaryStage.show();
        }


        public static void main(String[] args) {
            launch(args);
        }
}

