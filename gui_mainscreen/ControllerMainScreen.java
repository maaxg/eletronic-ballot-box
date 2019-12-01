package gui_mainscreen;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import main.Main;

public class ControllerMainScreen {
    private Stage stage = new Stage();
    @FXML
    private MenuItem closeMenu;
    @FXML
    private Button btnUrna;
    @FXML
    private Button btnEleitor;
    @FXML
    private Button btnCandidato;

    @FXML
    private void menuSair(ActionEvent ev){
        Main.mainScreen(stage).close();
    }
    @FXML
    private void menuUrna(ActionEvent e){
        Main.urnaScrenn(stage);
    }
    @FXML
    private void menuEleitor(ActionEvent e){
        Main.eleitorScreen(stage);
    }
    @FXML
    private void menuCandidato(ActionEvent e){
        Main.candidatoScreen(stage);
    }

}
