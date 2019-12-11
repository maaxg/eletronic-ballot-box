package main;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
                                                        //Passar path completo ao inves de só passar a referência
        FXMLLoader loader = new FXMLLoader(new File("C:\\Users\\PC\\IdeaProjects\\EletronicBallotBox\\src\\gui_login\\sample.fxml").toURI().toURL());
        Parent root = loader.load();
                //FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Acess Area");
        primaryStage.setScene(new Scene(root, 500,600));
        primaryStage.setResizable(true);
        primaryStage.show();
    }
    public static Stage mainScreen(Stage stage){

        try {
            FXMLLoader loader = new FXMLLoader(new File("C:\\Users\\PC\\IdeaProjects\\EletronicBallotBox\\src\\gui_mainscreen\\sampleMain.fxml").toURI().toURL());
            Parent root = loader.load();
            stage.setTitle("Fast acess");
            stage.setScene(new Scene(root, 600, 600));
            stage.setResizable(true);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stage;
    }
    public static Stage urnaScrenn(Stage stage){
        try{

            FXMLLoader loader_urna = new FXMLLoader(new File("C:\\Users\\PC\\IdeaProjects\\EletronicBallotBox\\src\\gui_urna\\sampleUrna.fxml").toURI().toURL());
            Parent root_urna = loader_urna.load();
            stage.setTitle("Urna");
            stage.setScene(new Scene(root_urna, 600, 600));
            stage.setResizable(true);
            stage.show();

        }catch(IOException e){
            e.getMessage();
        }
        return stage;

    }
    public static Stage partidosScrenn(Stage stage){
        try{
            FXMLLoader loader_partidos = new FXMLLoader(new File("C:\\Users\\PC\\IdeaProjects\\EletronicBallotBox\\src\\gui_partidos\\samplePartidos.fxml").toURI().toURL());
            Parent root_partidos = loader_partidos.load();
            stage.setTitle("Partidos");
            stage.setScene(new Scene(root_partidos, 600, 600));
            stage.show();
        }catch (IOException e){
            e.getMessage();
        }
        return stage;
    }
    public static Stage eleitorScreen(Stage stage){
        try {
            FXMLLoader loader_eleitor = new FXMLLoader(new File("C:\\Users\\PC\\IdeaProjects\\EletronicBallotBox\\src\\gui_eleitor\\sampleEleitor.fxml").toURI().toURL());
            Parent root_eleitor = loader_eleitor.load();
            stage.setTitle("Eleitor");
            stage.setScene(new Scene(root_eleitor, 600, 600));
            stage.setResizable(true);
            stage.show();
        }catch(IOException e){
            e.getMessage();
        }
        return stage;
    }
    public static Stage candidatoScreen(Stage stage){
        try{
            FXMLLoader loader_candidato = new FXMLLoader(new File("C:\\Users\\PC\\IdeaProjects\\EletronicBallotBox\\src\\gui_candidato\\sampleCandidato.fxml").toURI().toURL());
            Parent root_candidato = loader_candidato.load();
            stage.setTitle("Candidato");
            stage.setScene(new Scene(root_candidato, 600, 600));
            stage.setResizable(true);
            stage.show();
        }catch(IOException e){
            e.getMessage();
        }
        return stage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
