package gui_login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private Button button;
    @FXML
    private Image img;
    @FXML
    private Label label;
    @FXML
    private TextField txtLogin;
    @FXML
    private TextField txtSenha;
    @FXML
    private void handleButtonAction(ActionEvent e){
        System.out.println("You clicked here");
        label.setText("Seja bem-vindo " + txtLogin.getText() + ", sua senha é: " + txtSenha.getText());

        }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


}
