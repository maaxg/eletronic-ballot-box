package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
                                                            //Passar path completo ao inves de só passar a referência
        FXMLLoader loader = new FXMLLoader(new File("C:\\Users\\PC\\IdeaProjects\\EletronicBallotBox\\src\\gui_login\\sample.fxml").toURI().toURL());
        Parent root = loader.load();
                //FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Acess Area");
        primaryStage.setScene(new Scene(root, 500,600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
