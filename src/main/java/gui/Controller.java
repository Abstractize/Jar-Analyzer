package gui;

import adt.Graph;
import adt.GraphNode;
import adt.List;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
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

    private GraphicsContext gc;


    @FXML
    private Canvas graphContent;

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
    private void makeGraphics(){

        Random rand = new Random();

        int randWeight = rand.nextInt(540);
        int randHeight = rand.nextInt(520);

        GraphicsContext graphicsContext = graphContent.getGraphicsContext2D();
        graphicsContext.clearRect(0,0,graphContent.getWidth(),graphContent.getHeight());
        //graphicsContext.fillOval(randWeight,randHeight,30,30);

        //nodo1
//        graphicsContext.strokeOval(randHeight,randWeight,50,50);
//        graphicsContext.fillText("21",randHeight+15,randWeight+27);
//
//        //nodo2
//        graphicsContext.strokeOval(randHeight+50,randWeight+200,50,50);
//        graphicsContext.fillText("19",randHeight+15+50,randWeight+27+200);
//
//        //vertice
//        graphicsContext.strokeLine(randHeight+50-10,randWeight+50, randHeight+50+10,randWeight+200);
//
//        //vertcice 2.0
//        graphicsContext.strokeLine(50, 30, 210, 300);
//        graphicsContext.fillPolygon(
//                new double[] {200.0, 210.0, 200.0},
//                new double[] {25.0, 30.0, 35.0},
//                3
//        );

        ///Some aGraph
        Graph aGra = new Graph();
        GraphNode n1 = new GraphNode(1, "ichi");
        GraphNode n2 = new GraphNode(2, "ni");
        GraphNode n3 = new GraphNode(3, "san");
        GraphNode n4 = new GraphNode(4, "yon");
        GraphNode n5 = new GraphNode(5, "go");

        aGra.insertarVertice(n1, false);
        aGra.insertarVertice(n2, false);
        aGra.insertarVertice(n3, false);
        aGra.insertarVertice(n4, false);
        aGra.insertarVertice(n5, false);

        aGra.insertarArista(n1,n2);
        aGra.insertarArista(n2,n3);
        aGra.insertarArista(n3,n4);
        aGra.insertarArista(n1,n5);


        //Set of nodes,

        graphicsContext.strokeOval(50,50,50,50);
        graphicsContext.fillText(n1.getTag(), 65,75);

        graphicsContext.strokeOval(50+100,50-45,50,50);
        graphicsContext.fillText(n2.getTag(), 65+100,75-45);

        graphicsContext.strokeOval(50-45,50+100,50,50);
        graphicsContext.fillText(n3.getTag(), 65-45,75+100);

        graphicsContext.strokeOval(50+100-45,50+100-35,50,50);
        graphicsContext.fillText(n4.getTag(), 65+100-45,75+100-35);

        graphicsContext.strokeOval(50,50+200,50,50);
        graphicsContext.fillText(n5.getTag(), 65,75+200);

        //Set of edges,
            //n3 to n4
        graphicsContext.strokeLine(100-45,75+100,40+100-45,75+100);
        graphicsContext.fillPolygon(
                new double[] {100+40-45,50+100-45,100+40-45},
                new double[] {170,175,180},
                3
        );
            //n1 to n4
        graphicsContext.strokeLine(100-25,100,200-25-45-10+4,50+100-10+4);
        graphicsContext.fillPolygon(
                new double[] {200-79,200-70,150-45+25},
                new double[] {150-4,150-8,150},
                3
        );


        //First Level
        graphicsContext.strokeOval(50+200,50,50,50);
        graphicsContext.strokeOval(50+300,50-45,50,50);
        graphicsContext.strokeOval(50+400,50,50,50);

        //Second Level
        graphicsContext.strokeOval(50+200-45,50+100,50,50);
        graphicsContext.strokeOval(50+300-45,50+100,50,50);
        graphicsContext.strokeOval(50+400-45,50+100,50,50);

        //Third Level
        graphicsContext.strokeOval(50+100,50+200,50,50);
        graphicsContext.strokeOval(50+200,50+200,50,50);
        graphicsContext.strokeOval(50+300,50+200,50,50);
        graphicsContext.strokeOval(50+400,50+200,50,50);

        //Fourth Level
        graphicsContext.strokeOval(50-45,50+300,50,50);
        graphicsContext.strokeOval(50+100-45,50+300,50,50);
        graphicsContext.strokeOval(50+200-45,50+300,50,50);
        graphicsContext.strokeOval(50+300-45,50+300,50,50);
        graphicsContext.strokeOval(50+400-45,50+300,50,50);

        //Fifth Level
        graphicsContext.strokeOval(50,50+400,50,50);
        graphicsContext.strokeOval(50+100,50+400+30,50,50);
        graphicsContext.strokeOval(50+200,50+400,50,50);
        graphicsContext.strokeOval(50+300,50+400+30,50,50);
        graphicsContext.strokeOval(50+400,50+400,50,50);

    }

    @FXML
    private void makeAutomatedGraphics(){

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
        GraphNode<Integer> n11 = new GraphNode<Integer>(11, "ju ichi");
        GraphNode<Integer> n12 = new GraphNode<Integer>(12, "ju ni");
        GraphNode<Integer> n13 = new GraphNode<Integer>(13, "ju san");
        GraphNode<Integer> n14 = new GraphNode<Integer>(14, "ju yon");
        GraphNode<Integer> n15 = new GraphNode<Integer>(14, "ju go");
        GraphNode<Integer> n16 = new GraphNode<Integer>(16, "ju roku");
        GraphNode<Integer> n17 = new GraphNode<Integer>(17, "ju nana");
        GraphNode<Integer> n18 = new GraphNode<Integer>(18, "ju hachi");
        GraphNode<Integer> n19 = new GraphNode<Integer>(19, "ju kyu");
        GraphNode<Integer> n20 = new GraphNode<Integer>(20, "ni-ju");
        GraphNode<Integer> n21 = new GraphNode<Integer>(21, "ni-ju ichi");
        GraphNode<Integer> n22 = new GraphNode<Integer>(22, "ni-ju ni");
        GraphNode<Integer> n23 = new GraphNode<Integer>(23, "ni-ju san");
        GraphNode<Integer> n24 = new GraphNode<Integer>(24, "ni-ju yon");
        GraphNode<Integer> n25 = new GraphNode<Integer>(25, "ni-ju go");



        aGra.insertarVertice(n1, false);
        aGra.insertarVertice(n2, false);
        aGra.insertarVertice(n3, false);
        aGra.insertarVertice(n4, false);
        aGra.insertarVertice(n5, false);
        aGra.insertarVertice(n6, false);

        aGra.insertarArista(n1,n2);
        aGra.insertarArista(n2,n3);
        aGra.insertarArista(n3,n4);
        aGra.insertarArista(n1,n5);

        int nodesQuantity = aGra.getNumberOfNodes();

        GraphicsContext gc =  graphContent.getGraphicsContext2D();
        gc.clearRect(0,0,graphContent.getWidth(),graphContent.getHeight());

        System.out.println(nodesQuantity);

        int xPlus = 0;
        int yPlus = 0;

        for (int i=0;nodesQuantity>=i;i++) {

            if (i < 4) {

                gc.strokeOval(50 + xPlus, 50 + yPlus, 50, 50);
                gc.fillText("ni", 65,75);
                xPlus += 100;

            }if(i == 4){

                gc.strokeOval(50 + xPlus, 50 + yPlus, 50, 50);
                xPlus = -45;
                yPlus += 100;

            }if(4<i && i<8){

                gc.strokeOval(50 + xPlus, 50 + yPlus, 50, 50);
                xPlus += 100;

            }if(i == 8){

                xPlus = 0;
                yPlus += 100;
                gc.strokeOval(50 + xPlus, 50 + yPlus, 50, 50);
            }
        }



    }

    @FXML
    private void clearCanvas(){
        GraphicsContext gc = graphContent.getGraphicsContext2D();
        gc.clearRect(0,0,graphContent.getWidth(),graphContent.getHeight());
    }
    @FXML
    private void callGraphics(){
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
        File out = new File("c:/temp/graphviz-java-api/out." + type);    // Windows
        gv.writeGraphToFile( gv.getGraph(gv.getDotSource(), type, repesentationType), out );
    }






}
