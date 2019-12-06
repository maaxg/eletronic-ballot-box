package gui_candidato;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model_candidato.Candidato;
import model_candidato.dao.CandidatoDAO;
import model_partido.Partido;
import model_partido.dao.PartidoDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.net.URL;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ControllerCandidato implements Initializable {
    PartidoDAO dao = new PartidoDAO();
    CandidatoDAO dao_cand = new CandidatoDAO();
    @FXML
    private TextField txtNome_candidato;
    @FXML
    private TextField txtNumero_candidato;
    @FXML
    private ComboBox<Partido> comboPartido;
    @FXML
    private TableView<Candidato> tableCand;
    @FXML
    private TableColumn<Candidato, String> columNome;
    @FXML
    private TableColumn<Candidato, Integer> columNum;
    @FXML
    private TableColumn<Candidato, String> columPart;


    @FXML
    private Button btnSalvar_candidato;

    private ObservableList<Candidato> obs_cand;

    public List<Partido> part = new ArrayList<>();
    private ObservableList<Partido> obs_part;

    @FXML
    public void mostrarTabela(){
        obs_cand = FXCollections.observableArrayList(dao_cand.findAll());
        columNome.setCellValueFactory(
                new PropertyValueFactory<>("nome_candidato"));
        columNum.setCellValueFactory(
                new PropertyValueFactory<>("numero"));
        columPart.setCellValueFactory(
                new PropertyValueFactory<>("partido"));

        tableCand.setItems(obs_cand);
    }

    @FXML
    public void comboPartido() {
        obs_part = FXCollections.observableArrayList(dao.findAll());
        comboPartido.setItems(obs_part);
    }
    @FXML
    public void salvar_candidato(ActionEvent e){
        CandidatoDAO dao = new CandidatoDAO();
        Partido p = (Partido) comboPartido.getValue();
        Candidato c = new Candidato(3, txtNome_candidato.getText(), Integer.parseInt(txtNumero_candidato.getText()), p );

        if(dao.save_candidato(c)){
            JOptionPane.showMessageDialog(null, "Candidado salvo com sucesso");
        }else{
            JOptionPane.showMessageDialog(null,"Algo deu errado");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mostrarTabela();
        comboPartido();

    }

}
