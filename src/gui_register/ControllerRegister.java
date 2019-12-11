package gui_register;


import gui_login.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model_person.Person;
import model_person.dao.PersonDAO;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ControllerRegister implements Initializable {
    Person pe = new Person();
    @FXML
    public TextField txtNome;
    @FXML
    public TextField txtCpf;
    @FXML
    public TextField txtData_nasc;
    @FXML
    public TextField txtLogin_reg;
    @FXML
    public PasswordField txtSenha_reg;




    @FXML
    private void handleConfirmButton(ActionEvent e){
        Controller c = new Controller();
        PersonDAO dao = new PersonDAO();
        try {

            Person pe = new Person(2, txtNome.getText(), txtData_nasc.getText(), txtCpf.getText(), txtLogin_reg.getText(), txtSenha_reg.getText());
            dao.save(pe);
            JOptionPane.showMessageDialog(null,"Sucessfull registration");

        }catch(Exception exc){
            exc.printStackTrace();
        }finally {
            c.stage_reg.close();
        }
       
        

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
