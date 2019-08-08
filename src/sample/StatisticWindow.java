package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import jfxtras.styles.jmetro8.JMetro;

public class StatisticWindow extends Application {
    private String result;
    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("statistic.fxml"));
        Parent root = (Parent) loader.load();
        StatisticController statisticController = loader.getController();
        new JMetro(JMetro.Style.LIGHT).applyTheme(root);
        Scene myScene = new Scene(root);
        primaryStage.setTitle("Статистика");
        primaryStage.setScene(myScene);
        primaryStage.setResizable(false);

        //textarea
        TextArea textArea = (TextArea) myScene.lookup("#textArea");
        textArea.setText(result);
        primaryStage.show();

    }

    public void display(String result) throws Exception {
        this.result = result;
        start(new Stage());
    }
}
