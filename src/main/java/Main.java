//package main.java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {


        @Override
        public void start(Stage primaryStage) throws Exception{
            AnchorPane root = FXMLLoader.load(getClass().getResource("/fxml/GUI.fxml"));
            primaryStage.setTitle("Jar Analyzer");

            primaryStage.setScene(new Scene(root, 800, 600));
            primaryStage.show();
        }


        public static void main(String[] args) {
            launch(args);
        }
}

