package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import jfxtras.styles.jmetro8.JMetro;

public class Main extends Application {

    TableView<Graduate> table;
    ChoiceBox<String> educationForm, paymentType;
    Controller controller;
    @Override
    public void start(Stage primaryStage) throws Exception{
        //xml loading
        FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
        Parent root = (Parent) loader.load();
        controller = loader.getController();

        //set scene settings
        Scene myScene = new Scene(root);
        primaryStage.setTitle("Курсовая работа по ПЯВУ. Выполнил Мосенков В. А.");
        new JMetro(JMetro.Style.LIGHT).applyTheme(root);

        //action column
        TableColumn<Graduate, String> actionColumn = new TableColumn<>("Действия");
        actionColumn.setCellValueFactory(new PropertyValueFactory<>("action"));

        //passport column
        TableColumn<Graduate, String> passportColumn = new TableColumn<>("Номер паспорта");
        passportColumn.setCellValueFactory(new PropertyValueFactory<>("passport"));

        //specialty column
        TableColumn<Graduate, String> specialtyColumn = new TableColumn<>("Шифр специальности");
        specialtyColumn.setCellValueFactory(new PropertyValueFactory<>("specialtyCode"));

        //educationForm column
        TableColumn<Graduate, String> educationColumn = new TableColumn<>("Форма обучения");
        educationColumn.setCellValueFactory(new PropertyValueFactory<>("educationForm"));

        //paymentType column
        TableColumn<Graduate, String> paymentColumn = new TableColumn<>("Вид оплаты");
        paymentColumn.setCellValueFactory(new PropertyValueFactory<>("paymentType"));
        table = (TableView) myScene.lookup("#myTable");
        table.setItems(getGraduates(table));
        table.getColumns().addAll(actionColumn,passportColumn,specialtyColumn,educationColumn,paymentColumn);





        //choice boxes
        educationForm = (ChoiceBox<String>) myScene.lookup("#educationForm");
        paymentType = (ChoiceBox<String>) myScene.lookup("#paymentType");
        ObservableList<String> educationValues = FXCollections.observableArrayList("Очная", "Заочная");
        ObservableList<String> paymentValues = FXCollections.observableArrayList("Бюджет", "Коммерция");
        educationForm.setItems(educationValues);
        paymentType.setItems(paymentValues);
        educationForm.setValue("Очная");
        paymentType.setValue("Бюджет");

        //init stage
        primaryStage.setScene(myScene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public ObservableList<Graduate> getGraduates(TableView table){
        ObservableList<Graduate> graduates = FXCollections.observableArrayList();
        return graduates;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
