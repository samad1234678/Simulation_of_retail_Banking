package com.example.simulation_of_retail_banking.samad.Loan_officer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class ApproveandrejectloanController {

    @FXML
    private TableColumn<Applyprocess, LocalDate> applydatecloumn;

    @FXML
    private DatePicker applydatepickertextfield;

    @FXML
    private TableColumn<Applyprocess, Integer> cidcloumn;

    @FXML
    private TextField cidtextfield;

    @FXML
    private TableColumn<Applyprocess, String> cnamecloumn;

    @FXML
    private TextField cnametextfield;

    @FXML
    private TableColumn<Applyprocess, String> decissiongroupcloumn;

    @FXML
    private ComboBox<String> decissiongroupcombotextfield;

    @FXML
    private TextField loadidtextfield;

    @FXML
    private TableColumn<Applyprocess, Integer> loanidcloumn;

    @FXML
    private TextField loantypetextfield;

    @FXML
    private TableView<Applyprocess> tableview;
    @javafx.fxml.FXML
    public void initialize() {


    }

    @FXML
    void addalldatbution(ActionEvent event) {

    }

    @FXML
    void backbution(ActionEvent event) {

    }

    @FXML
    void showalldatabution(ActionEvent event) {

    }

}
