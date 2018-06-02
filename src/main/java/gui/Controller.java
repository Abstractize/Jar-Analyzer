package gui;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Input;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller {

    private Desktop desktop = Desktop.getDesktop();
    private FileChooser fileChooser = new FileChooser();
    private Stage stage;

    private Input DisplayGraph;

    private boolean fileBool = true;

    /**
     * Singleton for openDialog
     */
    public void openDialog() throws IOException{
        if (fileBool){
            openDialogAux();
        }
    }

    /**
     * Open windows explorer to search the path file.
     */
    private void openDialogAux() throws IOException{
        fileBool = false;
        configureFileChooser(fileChooser);
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            //openFile(file);
            System.out.println(getPathFile(file));
            DisplayGraph = new Input(getPathFile(file));

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



}
