package sample;


import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;

import java.util.Iterator;

public class Graduate {
    HBox action;
    private int id;
    private TableView table;
    private String passport,specialtyCode,educationForm, paymentType;

    public Graduate(int id,String passport, String specialtyCode, String educationForm, String paymentType, TableView table,Controller controller) {
        this.id = id;
        this.passport = passport;
        this.specialtyCode = specialtyCode;
        this.educationForm = educationForm;
        this.paymentType = paymentType;
        this.table = table;

        action = new HBox();
        Hyperlink edit = new Hyperlink("Редактировать");
        Hyperlink delete = new Hyperlink("Удалить");
        delete.setId("deleteLink");
        edit.setId("editLink");
        action.getChildren().addAll(edit,delete);
        action.setSpacing(10);
        action.setFillHeight(true);
        action.setStyle("-fx-background-color: transparent;");
        action.setAlignment(Pos.CENTER_LEFT);
        action.setMinWidth(250);

        //handle link
        delete.setOnAction(event -> {
            ObservableList<Graduate> allGraduates;
            allGraduates = table.getItems();
            Iterator iterator = allGraduates.iterator();
            while (iterator.hasNext()){
                Graduate graduate = (Graduate) iterator.next();
                if(graduate.getId() == this.id)
                    iterator.remove();
            }
            controller.setSearchFlag(false);
        });

        edit.setOnAction(event -> {
            EditWindow box = new EditWindow();
            try {
                box.display(this);
            } catch (Exception e) {
                e.printStackTrace();
            }
            controller.setSearchFlag(false);
        });




    }

    public TableView getTable() {
        return table;
    }

    public void setTable(TableView table) {
        this.table = table;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public HBox getAction() {
        return action;
    }

    public void setAction(HBox action) {
        this.action = action;
    }

    public String getSpecialtyCode() {
        return specialtyCode;
    }

    public void setSpecialtyCode(String specialtyCode) {
        this.specialtyCode = specialtyCode;
    }

    public String getEducationForm() {
        return educationForm;
    }

    public void setEducationForm(String educationForm) {
        this.educationForm = educationForm;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
}
