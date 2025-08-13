package com.example.simulation_of_retail_banking.samad.Loan_officer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class GenerateloanreportController {

    @FXML
    private TableColumn<?, ?> datecloumn;

    @FXML
    private TableColumn<?, ?> emailcloumn;

    @FXML
    private TextField emailtextfield;

    @FXML
    private ComboBox<?> gendercombotextfield;

    @FXML
    private TableColumn<?, ?> idcloumn;

    @FXML
    private TextField idtextfield;

    @FXML
    private TextField loanreportnametextfield;

    @FXML
    private TableColumn<?, ?> loanstatuscloumn;

    @FXML
    private ComboBox<?> loanstatustextfieldcombo;

    @FXML
    private TableColumn<?, ?> namecloumn;

    @FXML
    private TextField nametextfield;

    @FXML
    private DatePicker reportdatetextfield;

    @FXML
    private TableColumn<?, ?> reportnamecloumn;

    @FXML
    private TableColumn<?, ?> reporttypecloumn;

    @FXML
    private TextField reporttypetextfield;

    @FXML
    private TableView<?> tableview;

    @FXML
    void addtoallbution(ActionEvent event) {

    }

    @FXML
    void backbution(ActionEvent event) {

    }

    @FXML
    void showalldatabution(ActionEvent event) {

    }

}
