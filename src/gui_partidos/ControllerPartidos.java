package gui_partidos;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model_partido.Partido;
import model_partido.dao.PartidoDAO;
import model_person.dao.PersonDAO;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;


public class ControllerPartidos implements Initializable {
    PartidoDAO dao = new PartidoDAO();
    @FXML
    private TextField txtNome_partido;
    @FXML
    private TableView<Partido> tablePartido;
    @FXML
    private TableColumn<Partido, Integer> columnId;
    @FXML
    private TableColumn<Partido, String> columnNome;

    private ObservableList<Partido> obs_part;


    @FXML
    public void tablePartido(){
        obs_part = FXCollections.observableArrayList(dao.findAll());
        columnId.setCellValueFactory(new PropertyValueFactory<>("idpartido"));
        columnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tablePartido.setItems(obs_part);
    }

    @FXML
    public void handleActionSalvar(ActionEvent e){
        PartidoDAO dao = new PartidoDAO();
        Partido p = new Partido(4, txtNome_partido.getText());

        if(dao.save_partido(p)){
            JOptionPane.showMessageDialog(null,"Partido cadastrado com sucesso");
        }else{
            JOptionPane.showMessageDialog(null,"Falha ao salvar");
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tablePartido();
    }
}
