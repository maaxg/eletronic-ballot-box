package gui_urna;


import class_methods.TextFieldFormatter;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;


public class ControllerUrna implements Initializable{

    @FXML
    private TextField txtCpf;

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
