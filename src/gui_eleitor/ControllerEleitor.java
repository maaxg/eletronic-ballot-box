package gui_eleitor;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model_eleitor.Eleitor;
import model_eleitor.dao.EleitorDAO;
import tft_formatter.TextFieldFormatter;

import java.net.URL;
import java.util.ResourceBundle;


public class ControllerEleitor implements Initializable {
    EleitorDAO dao = new EleitorDAO();
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
    private TableView<Eleitor> tableEleitor;
    @FXML
    private TableColumn<Eleitor, String> columnNome;
    @FXML
    private TableColumn<Eleitor, String> columnCpf;
    @FXML
    private TableColumn<Eleitor, String> columnCep;

    private ObservableList<Eleitor> obs_elet;

    @FXML
    public void tabelaEleitor(){
        obs_elet = FXCollections.observableArrayList(dao.findAll());
        columnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        columnCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        columnCep.setCellValueFactory(new PropertyValueFactory<>("cep"));
        tableEleitor.setItems(obs_elet);
    }

    @FXML
    public void salvar_eleitor(ActionEvent e){

        EleitorDAO dao = new EleitorDAO();
        try{
            Eleitor el = new Eleitor(txtNome_eleitor.getText(), txtCpf_eleitor.getText(), txtCep_eleitor.getText(), txtBairro_eleitor.getText(), txtRua_eleitor.getText(), Integer.parseInt(txtNumero_eleitor.getText()));
            dao.checkCpf(txtCpf_eleitor.getText());
            dao.save(el);

        }catch (Exception ex){
            System.err.println("Erro " +ex);
        }
    }

    @FXML
    public void tffCpf_masc(){
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("###.###.###-##");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txtCpf_eleitor);
        tff.formatter();
    }
    @FXML
    public void tffCep_masc(){
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("#####-###");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txtCep_eleitor);
        tff.formatter();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tabelaEleitor();
    }
}
