package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.net.URL;
import java.util.ResourceBundle;


public class EditController implements Initializable {

    private TableView tableView;
    private Stage stage;
    private Graduate graduate;

    @FXML
    private TextField passport;

    @FXML
    private TextField specialty;

    @FXML
    private ChoiceBox education;

    @FXML
    private ChoiceBox payment;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void initFields(TableView tableView, Stage stage, Graduate graduate){
        this.tableView = tableView;
        this.stage = stage;
        this.graduate = graduate;
    }

    public void close(){
        stage.close();
    }

    public void save(){
        graduate.setPassport(passport.getText());
        graduate.setSpecialtyCode(specialty.getText());
        graduate.setEducationForm(education.getValue().toString());
        graduate.setPaymentType(payment.getValue().toString());
        tableView.refresh();
        stage.close();
    }
}
