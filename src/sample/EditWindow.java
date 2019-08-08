package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import jfxtras.styles.jmetro8.JMetro;



public class EditWindow extends Application {
    Graduate graduate;
    @Override
    public void start(Stage primaryStage) throws Exception {
        //xml loading
        FXMLLoader loader = new FXMLLoader(getClass().getResource("editor.fxml"));
        Parent root = (Parent) loader.load();
        EditController editController = loader.getController();
        editController.initFields(graduate.getTable(), primaryStage, graduate);
        new JMetro(JMetro.Style.LIGHT).applyTheme(root);
        Scene myScene = new Scene(root);
        primaryStage.setTitle("Редактирование");
        primaryStage.setScene(myScene);
        primaryStage.setResizable(false);

        TextField passport = (TextField) myScene.lookup("#passport");
        TextField specialty = (TextField) myScene.lookup("#specialty");

        ChoiceBox<String> educationForm = (ChoiceBox<String>) myScene.lookup("#education");
        ChoiceBox<String> paymentType = (ChoiceBox<String>) myScene.lookup("#payment");
        ObservableList<String> educationValues = FXCollections.observableArrayList("Очная", "Заочная");
        ObservableList<String> paymentValues = FXCollections.observableArrayList("Бюджет", "Коммерция");
        educationForm.setItems(educationValues);
        paymentType.setItems(paymentValues);
        educationForm.setValue(graduate.getEducationForm());
        paymentType.setValue(graduate.getPaymentType());
        specialty.setText(graduate.getSpecialtyCode());
        passport.setText(graduate.getPassport());
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        primaryStage.show();
    }

    public void display(Graduate graduate) throws Exception {
        this.graduate = graduate;

        start(new Stage());
    }
}
