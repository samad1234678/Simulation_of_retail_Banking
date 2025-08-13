package com.example.simulation_of_retail_banking.samad.Branch_manager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ScheduleStaffShiftsController {

    @FXML
    private TextField endtimetextfeld;

    @FXML
    private TableColumn<?, ?> shiftdateclumn;

    @FXML
    private DatePicker shiftdatepicketfeld;

    @FXML
    private TableColumn<?, ?> shiftendtimecolumn;

    @FXML
    private TableColumn<?, ?> shiftstarttimecolumn;

    @FXML
    private ComboBox<?> shifttimecombofeld;

    @FXML
    private TableColumn<?, ?> shifttypecolumn;

    @FXML
    private TableColumn<?, ?> stafidcolum;

    @FXML
    private TextField stafidtextfeld;

    @FXML
    private TableColumn<?, ?> stafnamecolumn;

    @FXML
    private TextField stafnametextfeld;

    @FXML
    private TextField starttimetextfeld;

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
