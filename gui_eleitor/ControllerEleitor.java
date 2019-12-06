package gui_eleitor;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model_eleitor.Eleitor;
import model_eleitor.dao.EleitorDAO;

import javax.swing.*;
import java.sql.SQLException;

public class ControllerEleitor {
    @FXML
    private TextField txtNome_eleitor;
    @FXML
    private TextField txtCpf_eleitor;
    @FXML
    private TextField txtCep_eleitor;
    @FXML
    private TextField txtBairro_eleitor;
    @FXML
    private TextField txtRua_eleitor;
    @FXML
    private TextField txtNumero_eleitor;

    @FXML
    public void salvar_eleitor(ActionEvent e){

        EleitorDAO dao = new EleitorDAO();
        try{
            Eleitor el = new Eleitor(txtNome_eleitor.getText(), txtCpf_eleitor.getText(), txtCep_eleitor.getText(), txtBairro_eleitor.getText(), txtRua_eleitor.getText(), Integer.parseInt(txtNumero_eleitor.getText()));
            dao.save(el);
            //o.checkCpf(txtCpf_eleitor.getText());
        }catch (Exception ex){
            System.err.println("Erro " +ex);
        }
    }
    @FXML
    public void deletar_eleitor(ActionEvent e){

    }
}
