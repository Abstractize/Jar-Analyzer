//package main.java;

import gui.Controller;
import gui.PannableCanvas;
import gui.SceneGestures;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;



public class Main extends Application {


        @Override
        public void start(Stage primaryStage) throws Exception{
            AnchorPane root = FXMLLoader.load(getClass().getResource("/fxml/GUI.fxml"));

            primaryStage.getIcons().add(new Image("/images/iconJar.png"));
            primaryStage.setTitle("Jar Analyzer");
            Scene scene = new Scene(root, 800, 600);

//            Canvas realCanvas = new Canvas();
//            realCanvas.setHeight(531);
//            realCanvas.setWidth(560);
//            PannableCanvas canvas = new PannableCanvas();
//            canvas.setTranslateX(1000);
//            canvas.setTranslateY(100);
//
//            SceneGestures sceneGestures = new SceneGestures(canvas);
//            scene.addEventFilter( MouseEvent.MOUSE_PRESSED, sceneGestures.getOnMousePressedEventHandler());
//            scene.addEventFilter( MouseEvent.MOUSE_DRAGGED, sceneGestures.getOnMouseDraggedEventHandler());
//            scene.addEventFilter( ScrollEvent.ANY, sceneGestures.getOnScrollEventHandler());
//
//            GraphicsContext gc = realCanvas.getGraphicsContext2D();
//            gc.clearRect(0,0,realCanvas.getWidth(),realCanvas.getHeight());
//            Image img = new Image("file:///C:/temp/graphviz-java-api/out.png");
//            gc.drawImage(img,0,0,560,531);
//
//            canvas.getChildren().add(realCanvas);
//            root.getChildren().add(canvas);


            primaryStage.setScene(scene);
            primaryStage.show();

        }


        public static void main(String[] args) {
            launch(args);
        }
}

