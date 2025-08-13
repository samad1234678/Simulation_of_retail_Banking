package com.example.simulation_of_retail_banking.samad.Branch_manager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class GenerateBranchPerformanceReportsController {

    @FXML
    private TextField branchareatextfield;

    @FXML
    private TableColumn<?, ?> branchcodecloumn;

    @FXML
    private TextField branchcodetextfield;

    @FXML
    private TextField branchnametextfield;

    @FXML
    private TableColumn<?, ?> branchnmecloumn;

    @FXML
    private TableColumn<?, ?> reportenddatecloumn;

    @FXML
    private DatePicker reportenddatetextfield;

    @FXML
    private TableColumn<?, ?> reportstartdatecloumn;

    @FXML
    private DatePicker reportstarttextfield;

    @FXML
    private TableColumn<?, ?> reporttypecloumn;

    @FXML
    private ComboBox<?> reporttypetextcombofield;

    @FXML
    private TableView<?> tableview;

    @FXML
    void addalldatabution(ActionEvent event) {

    }

    @FXML
    void backbution(ActionEvent event) {

    }

    @FXML
    void showalldatabution(ActionEvent event) {

    }

}
