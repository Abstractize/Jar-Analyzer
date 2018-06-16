package gui;

import adt.Graph;
import adt.GraphNode;
import adt.List;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeLineCap;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller {

    private Desktop desktop = Desktop.getDesktop();

    private FileChooser fileChooser = new FileChooser();

    private Stage stage;


    private boolean fileBool = true;

    private Scene scene;

    public void setScene(Scene scene) { this.scene = scene; }


    @FXML
    private Canvas graphContent;
    @FXML
    private HBox progressCanvas;
    @FXML
    private HBox realCanvas;

    private void dT(){

        PannableCanvas canvas = new PannableCanvas();
        canvas.setTranslateX(100);
        canvas.setTranslateY(100);

        javafx.scene.shape.Rectangle rect1 = new Rectangle(100,100);
        rect1.setTranslateX(450);
        rect1.setTranslateY(450);
        rect1.setStroke(Color.BLUE);
        rect1.setFill(Color.BLUE.deriveColor(1, 1, 1, 0.5));

        canvas.getChildren().add(rect1);

        SceneGestures sceneGestures = new SceneGestures(canvas);
        scene.addEventFilter( MouseEvent.MOUSE_PRESSED, sceneGestures.getOnMousePressedEventHandler());
        scene.addEventFilter( MouseEvent.MOUSE_DRAGGED, sceneGestures.getOnMouseDraggedEventHandler());
        scene.addEventFilter( ScrollEvent.ANY, sceneGestures.getOnScrollEventHandler());

        realCanvas.getChildren().add(canvas);

    }

    private void wT() {
        final Slider slider = new Slider();
        slider.setMin(0);
        slider.setMax(50);

        final ProgressBar pb = new ProgressBar(0);
        final ProgressIndicator pi = new ProgressIndicator(0);

        slider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                                Number old_val, Number new_val) {
                pb.setProgress(new_val.doubleValue()/50);
                pi.setProgress(new_val.doubleValue()/50);
            }
        });
        progressCanvas.getChildren().addAll(slider,pb,pi);
    }

    /**
     * Singleton for openDialog
     */
    public void openDialog(){
        if (fileBool){
            openDialogAux();
        }
    }

    /**
     * Open windows explorer to search the path file.
     */
    private void openDialogAux(){
        fileBool = false;
        configureFileChooser(fileChooser);
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            openFile(file);
            getPathFile(file);
        }

        fileBool = true;
    }

    /**
     * Open a file in windows explorer
     * @param file file, in this case a .jar
     */
    private void openFile(File file) {
        try {
            desktop.open(file);

        } catch (IOException ex) {

            Logger.getLogger(
                    Controller.class.getName()).log(
                    Level.SEVERE, null, ex
            );
        }
    }

    /**
     * File Chooser configuration. It only recognize to open .jar files.
     * @param fileChooser FileChooser javafx component
     */
    private static void configureFileChooser(
            final FileChooser fileChooser) {
        fileChooser.setTitle("View Pictures");
        fileChooser.setInitialDirectory(
                new File(System.getProperty("user.home"))
        );
        fileChooser.getExtensionFilters().addAll(

                new FileChooser.ExtensionFilter("JAR", "*.jar")
        );
    }

    /**
     * Get the path file
     * @param file file .jar
     * @return String path file
     */
    private String getPathFile(File file){

        System.out.println(file.getPath());

        return file.getPath();
    }

    @FXML
    private void clearCanvas(){
        GraphicsContext gc = graphContent.getGraphicsContext2D();
        gc.clearRect(0,0,graphContent.getWidth(),graphContent.getHeight());
        wT();
        //dT();
    }

    @FXML
    private void drawGraph(){
        GraphicsContext gc = graphContent.getGraphicsContext2D();
        gc.clearRect(0,0,graphContent.getWidth(),graphContent.getHeight());
        Image img = new Image("file:///C:/temp/graphviz-java-api/out.png");
        gc.drawImage(img,0,0,560,531);

    }

    @FXML
    private void makeGraph(){

        Graph<Integer> aGra = new Graph<Integer>();
        GraphNode<Integer> n1 = new GraphNode<Integer>(1, "ichi");
        GraphNode<Integer> n2 = new GraphNode<Integer>(2, "ni");
        GraphNode<Integer> n3 = new GraphNode<Integer>(3, "san");
        GraphNode<Integer> n4 = new GraphNode<Integer>(4, "yon");
        GraphNode<Integer> n5 = new GraphNode<Integer>(5, "go");
        GraphNode<Integer> n6 = new GraphNode<Integer>(6, "roku");
        GraphNode<Integer> n7 = new GraphNode<Integer>(7, "nana");
        GraphNode<Integer> n8 = new GraphNode<Integer>(8, "hachi");
        GraphNode<Integer> n9 = new GraphNode<Integer>(9, "kyu");
        GraphNode<Integer> n10 = new GraphNode<Integer>(10, "ju");
        GraphNode<Integer> n11 = new GraphNode<Integer>(11, "ju_ichi");
        GraphNode<Integer> n12 = new GraphNode<Integer>(12, "ju_ni");
        GraphNode<Integer> n13 = new GraphNode<Integer>(13, "ju_san");
        GraphNode<Integer> n14 = new GraphNode<Integer>(14, "ju_yon");
        GraphNode<Integer> n15 = new GraphNode<Integer>(14, "ju_go");
        GraphNode<Integer> n16 = new GraphNode<Integer>(16, "ju_roku");
        GraphNode<Integer> n17 = new GraphNode<Integer>(17, "ju_nana");
        GraphNode<Integer> n18 = new GraphNode<Integer>(18, "ju_hachi");
        GraphNode<Integer> n19 = new GraphNode<Integer>(19, "ju_kyu");
        GraphNode<Integer> n20 = new GraphNode<Integer>(20, "ni_ju");
        GraphNode<Integer> n21 = new GraphNode<Integer>(21, "ni_ju_ichi");
        GraphNode<Integer> n22 = new GraphNode<Integer>(22, "ni_ju_ni");
        GraphNode<Integer> n23 = new GraphNode<Integer>(23, "ni_ju_san");
        GraphNode<Integer> n24 = new GraphNode<Integer>(24, "ni_ju_yon");
        GraphNode<Integer> n25 = new GraphNode<Integer>(25, "ni_ju_go");

        aGra.insertarArista(n1,n2);
        aGra.insertarArista(n3,n1);
        aGra.insertarArista(n2,n1);
        aGra.insertarArista(n5,n1);
        aGra.insertarArista(n6,n1);
        aGra.insertarArista(n10,n1);
        aGra.insertarArista(n7,n8);
        aGra.insertarArista(n8,n9);
        aGra.insertarArista(n1,n9);
        aGra.insertarArista(n4,n10);
        aGra.insertarArista(n4,n11);
        aGra.insertarArista(n5,n16);
        aGra.insertarArista(n4,n16);
        aGra.insertarArista(n16,n11);
        aGra.insertarArista(n11,n17);
        aGra.insertarArista(n4,n17);
        aGra.insertarArista(n18,n17);
        aGra.insertarArista(n17,n1);
        aGra.insertarArista(n3,n21);
        aGra.insertarArista(n21,n1);
        aGra.insertarArista(n3,n22);
        aGra.insertarArista(n22,n25);
        aGra.insertarArista(n23,n24);
        aGra.insertarArista(n13,n25);
        aGra.insertarArista(n4,n24);
        aGra.insertarArista(n13,n21);
        aGra.insertarArista(n21,n11);


        //System.out.println(aGra.getEdgesList());
        System.out.println(aGra.getAristas());

        GraphViz gv = new GraphViz();
        gv.addln(gv.start_graph());

        List<List<String>> stringMatrix = aGra.getStringList();

        for (int i = 0; i<stringMatrix.getLength(); i++){
            for(int j = 0; j<stringMatrix.getValue(i).getLength()-1;j++){

                gv.addln(stringMatrix.getValue(i).getValue(j)+" -> "+stringMatrix.getValue(i).getValue(j+1)+";");
            }
        }

        gv.addln(gv.end_graph());
        System.out.println(gv.getDotSource());

        gv.increaseDpi();   // 106 dpi

        //	    String type = "gif";
        //      String type = "dot";
        //      String type = "fig";    // open with xfig
        //      String type = "pdf";
        //      String type = "ps";
        //      String type = "svg";    // open with inkscape
        String type = "png";
        //      String type = "plain";

        String repesentationType= "dot";
        //		String repesentationType= "neato";
        //		String repesentationType= "fdp";
        //		String repesentationType= "sfdp";
        // 		String repesentationType= "twopi";
        // 		String repesentationType= "circo";

        //File out = new File("/tmp/out"+gv.getImageDpi()+"."+ type);   // Linux

        boolean temp = new File("c:/temp/graphviz-java-api/out." + type).mkdirs();  // Windows
        if (!temp)
            System.out.println("Failed creating the new directory");

        File out = new File("c:/temp/graphviz-java-api/out." + type);
        gv.writeGraphToFile( gv.getGraph(gv.getDotSource(), type, repesentationType), out );
    }






}
