package gui_login;

import class_methods.PersonMethods;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model_person.Person;
import model_person.dao.PersonDAO;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public Stage stage_reg = new Stage();

    @FXML
    private Button button;
    private Button button1;
    @FXML
    private Label label;
    @FXML
    private TextField txtLogin;
    @FXML
    private PasswordField txtSenha;


    @FXML
    private void handleButtonAction(ActionEvent e){
        PersonDAO dao = new PersonDAO();
        String user= txtLogin.getText();
        String pass = txtSenha.getText();
        System.out.println("You clicked here");
        dao.checkLogin(user, pass);
        label.setText("Seja bem-vindo " + txtLogin.getText() + ", sua senha é: " + txtSenha.getText());



        }
    @FXML
    public void handleButtonActionRegister(ActionEvent e) throws IOException {
        FXMLLoader loader_register = new FXMLLoader(new File("C:\\Users\\PC\\IdeaProjects\\EletronicBallotBox\\src\\gui_register\\sampleRegister.fxml").toURI().toURL());
        Parent root_reg = loader_register.load();
        stage_reg.setScene(new Scene(root_reg, 500, 600));
        stage_reg.setTitle("Register Area");
        stage_reg.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


}
