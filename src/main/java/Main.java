//package main.java;

import gui.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {


        @Override
        public void start(Stage primaryStage) throws Exception{
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/GUI.fxml"));
            primaryStage.setTitle("Jar Analyzer");

            //test
            //Controller controller = new Controller();
            //controller.openDialog(primaryStage);


            primaryStage.setScene(new Scene(root, 800, 600));
            primaryStage.show();
        }


        public static void main(String[] args) {
            launch(args);
        }
}

