package gui_urna;


import javafx.scene.control.Label;
import model_eleitor.Eleitor;
import model_urna.Urna;
import model_urna.dao.UrnaDAO;
import tft_formatter.TextFieldFormatter;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;


public class ControllerUrna implements Initializable{

    @FXML
    private TextField txtCpf;
    @FXML
    private TextField txtNumCandidato;
    @FXML
    private Label lbCd13;
    @FXML
    private Label lbCd17;
    @FXML
    private Label lbCd30;
    @FXML
    private Label lb18;

    @FXML
    public void mostrarCandidato(){
        if(txtNumCandidato.getText().equals("13")){
            lbCd13.setVisible(true);
        }
        else if(txtNumCandidato.getText().equals("17")){
            lbCd17.setVisible(true);
        }else if(txtNumCandidato.getText().equals("30")){
            lbCd30.setVisible(true);
        }else if(txtNumCandidato.getText().equals("18")){
            lb18.setVisible(true);
        }else if(txtNumCandidato.getText().equals("") || txtNumCandidato.getText().equals("1")){
            lbCd13.setVisible(false);
            lbCd17.setVisible(false);
            lbCd30.setVisible(false);
            lb18.setVisible(false);
        }
    }
    @FXML
    public void votoBranco(){
        UrnaDAO dao = new UrnaDAO();
        Eleitor e = new Eleitor();
        e.setCpf(txtCpf.getText());
        Urna u = new Urna(e, 0000);
        if(dao.checkCPF(txtCpf.getText())){
        }else {
            dao.save(u);
        }
    }
    @FXML
    public void salvarVoto(){
        UrnaDAO dao = new UrnaDAO();

        Eleitor e = new Eleitor();
        e.setCpf(txtCpf.getText());
        Urna u = new Urna(e, Integer.parseInt(txtNumCandidato.getText()));
        if(dao.checkCPF(txtCpf.getText())){
        } else {
            dao.save(u);
        }
        }

    @FXML
    public void tfCpf_mascara(){
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("###.###.###-##");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txtCpf);
        tff.formatter();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
