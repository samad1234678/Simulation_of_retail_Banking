package com.example.simulation_of_retail_banking.samad.Branch_manager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class TransferEmployeesBetweenBranchesController {

    @FXML
    private TableColumn<?, ?> branchfromcloumn;

    @FXML
    private TextField branchfromtextfield;

    @FXML
    private TableColumn<?, ?> branchtocloumn;

    @FXML
    private TextField branchtotextfield;

    @FXML
    private TableColumn<?, ?> clientnamecloumn;

    @FXML
    private TextField clientnametextfield;

    @FXML
    private TableColumn<?, ?> employeecloumn;

    @FXML
    private TextField employeeidtextfield;

    @FXML
    private TableColumn<?, ?> employeenamecloumn;

    @FXML
    private TextField employeenametextfield;

    @FXML
    private TableView<?> tableview;

    @FXML
    private TableColumn<?, ?> transferdatecloumn;

    @FXML
    private DatePicker transferdatepeekertextfield;

    @FXML
    void addallbution(ActionEvent event) {

    }

    @FXML
    void backbution(ActionEvent event) {

    }

    @FXML
    void showalldatabution(ActionEvent event) {

    }

}
