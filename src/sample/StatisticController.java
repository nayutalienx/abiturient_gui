package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class StatisticController implements Initializable {

    @FXML
    private Button close;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void close(){
       Stage stage =(Stage)close.getScene().getWindow();
       stage.close();
    }
}
