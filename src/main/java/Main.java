//package main.java;

import adt.Graph;
import adt.GraphNode;
import gui.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {


        @Override
        public void start(Stage primaryStage) throws Exception{
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/GUI.fxml"));
            primaryStage.getIcons().add(new Image("/images/iconJar.png"));
            primaryStage.setTitle("Jar Analyzer");

            //test
            //Controller controller = new Controller();
            //controller.openDialog(primaryStage);


            primaryStage.setScene(new Scene(root, 800, 600));
            primaryStage.show();

            //a graph

//            Graph aGra = new Graph();
//            GraphNode n1 = new GraphNode(1, "ichi");
//            GraphNode n2 = new GraphNode(2, "ni");
//            GraphNode n3 = new GraphNode(3, "san");
//            GraphNode n4 = new GraphNode(4, "yon");
//            GraphNode n5 = new GraphNode(5, "go");
//
//            aGra.insertarVertice(n1, false);
//            aGra.insertarVertice(n2, false);
//            aGra.insertarVertice(n3, false);
//            aGra.insertarVertice(n4, false);
//            aGra.insertarVertice(n5, false);
//
//            aGra.insertarArista(n1,n2);
//            aGra.insertarArista(n2,n3);
//            aGra.insertarArista(n3,n4);
//            aGra.insertarArista(n1,n5);
//
//            System.out.println(aGra.getAristas()+"mas");
//
//            System.out.println("som");
        }


        public static void main(String[] args) {
            launch(args);
        }
}

