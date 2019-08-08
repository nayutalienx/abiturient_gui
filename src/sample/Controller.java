package sample;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import sun.reflect.generics.tree.Tree;

import java.io.*;
import java.util.*;

public class Controller {

    ObservableList<Graduate> primaryList;
    boolean searchFlag = false;


    @FXML
    private TextField passport;

    @FXML
    private TextField specialty;

    @FXML
    private ChoiceBox educationForm;

    @FXML
    private ChoiceBox paymentType;

    @FXML
    private TableView tableView;

    @FXML
    private TextField search;

    public boolean isSearchFlag() {
        return searchFlag;
    }

    public void setSearchFlag(boolean searchFlag) {
        this.searchFlag = searchFlag;
    }

    public void addGraduate(){
        tableView.getItems().add(new Graduate(tableView.getItems().size() + 1,passport.getText(), specialty.getText(), educationForm.getValue().toString(), paymentType.getValue().toString(),tableView,this));
        passport.clear();
        specialty.clear();
        searchFlag = false;

    }

    public void showStatModal() throws Exception {
        StatisticWindow statisticWindow = new StatisticWindow();
        StringBuilder result = new StringBuilder();
        ObservableList<Graduate> list = tableView.getItems();
        Set<String> mySpecialties = new TreeSet<String>();
        for (Graduate gradudate:list) {
            mySpecialties.add(gradudate.getSpecialtyCode());
        }
        result.append("Студентов: "+list.size()+"\n");
        result.append("Cпециальностей: " + mySpecialties.size()+"\n\n\n");

        Iterator iterator = mySpecialties.iterator();
        while (iterator.hasNext()){
            String specCode = iterator.next().toString();
            result.append(String.format("На специальности %s обучается:",specCode));
            int amountStudents = 0;
            for (Graduate gradudate:list){
                if(gradudate.getSpecialtyCode().equals(specCode)) amountStudents++;
            }
            result.append(String.format(" %d (студентов).\nНа очной форме:",amountStudents));
            int firstForm = 0;
            for (Graduate gradudate:list){
                if(gradudate.getSpecialtyCode().equals(specCode) && gradudate.getEducationForm().equals("Очная")) firstForm++;
            }
            result.append(String.format(" %d\nНа заочной форме:",firstForm));
            int secondForm = 0;
            for (Graduate gradudate:list){
                if(gradudate.getSpecialtyCode().equals(specCode) && gradudate.getEducationForm().equals("Заочная")) secondForm++;
            }
            result.append(String.format(" %d\nБюджетников:",secondForm));
            int firstPayment = 0;
            for (Graduate gradudate:list){
                if(gradudate.getSpecialtyCode().equals(specCode) && gradudate.getPaymentType().equals("Бюджет")) firstPayment++;
            }
            result.append(String.format(" %d\nКоммерческих:",firstPayment));
            int secondPayment = 0;
            for (Graduate gradudate:list){
                if(gradudate.getSpecialtyCode().equals(specCode) && gradudate.getPaymentType().equals("Коммерция")) secondPayment++;
            }
            result.append(String.format(" %d\n_________________\n",secondPayment));
        }

        statisticWindow.display(result.toString());
    }

    public void searchProcess(){
        String request = search.getText();
        if(searchFlag == false){
            primaryList = FXCollections.observableArrayList();
            ObservableList<Graduate> list = tableView.getItems();
            for (Graduate graduate:list) {
                primaryList.add(graduate);
            }
            searchFlag = true;
        }

        ObservableList<Graduate> result = FXCollections.observableArrayList();
        if(request.equals("") || request.equals(" ")){
            for (Graduate graduate:primaryList) {
                result.add(graduate);
            }
        } else {



            for (Graduate graduate : primaryList) {
                if (graduate.getPassport().contains(request)) {
                    if (!result.contains(graduate))
                        result.add(graduate);
                } else if (graduate.getSpecialtyCode().contains(request)) {
                    if (!result.contains(graduate))
                        result.add(graduate);
                } else if (graduate.getEducationForm().contains(request)) {
                    if (!result.contains(graduate))
                        result.add(graduate);
                } else if (graduate.getPaymentType().contains(request)) {
                    if (!result.contains(graduate))
                        result.add(graduate);
                }
            }
        }
        tableView.setItems(result);
        tableView.refresh();
    }

    public void openFile(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Загрузка таблицы");
        File file = fileChooser.showOpenDialog(new Stage());
        ObservableList<Graduate> list = tableView.getItems();
        list.removeAll();

        String line;
        BufferedReader inp = null;
        String[] data = new String[4];

        Date date = new Date();
        long date1 = date.getTime();
        System.out.println("Start - " + date1);

        try{
            inp = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            while ((line = inp.readLine()) != null){
                line = line.trim();
                if(line.equals("")) continue;
                data = line.split("\\s+");

                list.add(new Graduate(list.size() + 1,data[0],data[1],data[2],data[3], tableView, this));
            }
        } catch (Exception e){
            System.out.println("Error - " + e.getMessage());
        }
        Date date11 = new Date();
        long date2 = date11.getTime();
        System.out.println("End - " + date2);
        System.out.println("delta - " +(date1 - date2));
    }

    public void saveFile(){

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Сохранение таблицы");
        File file = fileChooser.showSaveDialog(new Stage());
        ObservableList<Graduate> list = tableView.getItems();
        PrintWriter out = null;
        try{

            out = new PrintWriter(new FileWriter(file.getAbsoluteFile()));
            for (Graduate graduate:list) {
                StringBuilder line = new StringBuilder();
                line.append(String.format("%s %s %s %s",graduate.getPassport(), graduate.getSpecialtyCode(), graduate.getEducationForm(), graduate.getPaymentType()));
                out.println(line.toString());
            }
        }
        catch (IOException e){
            System.out.println(e);
        }
        finally {
            if(out != null) out.close();
        }

    }

    public void close(){
        Stage stage = (Stage) tableView.getScene().getWindow();
        stage.close();
    }

}
