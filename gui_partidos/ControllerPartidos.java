package gui_partidos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model_partido.Partido;
import model_partido.dao.PartidoDAO;
import model_person.dao.PersonDAO;

import javax.swing.*;


public class ControllerPartidos {
    @FXML
    private TextField txtNome_partido;

    @FXML
    public void handleActionSalvar(ActionEvent e){
        PartidoDAO dao = new PartidoDAO();
        Partido p = new Partido(3, txtNome_partido.getText());

        if(dao.save_partido(p)){
            JOptionPane.showMessageDialog(null,"Partido cadastrado com sucesso");
        }else{
            JOptionPane.showMessageDialog(null,"Falha ao salvar");
        }

    }
}
