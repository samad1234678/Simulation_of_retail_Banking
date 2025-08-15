package com.example.simulation_of_retail_banking.samad.Loan_officer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ApproveandrejectloanController {

    @FXML
    private TableColumn<Approveprocess, LocalDate> applydatecloumn;

    @FXML
    private DatePicker applydatepickertextfield;

    @FXML
    private TableColumn<Approveprocess, Integer> cidcloumn;

    @FXML
    private TextField cidtextfield;

    @FXML
    private TableColumn<Approveprocess, String> cnamecloumn;

    @FXML
    private TextField cnametextfield;

    @FXML
    private TableColumn<Approveprocess, String> decissiongroupcloumn;

    @FXML
    private ComboBox<String> decissiongroupcombotextfield;

    @FXML
    private TextField loadidtextfield;

    @FXML
    private TableColumn<Approveprocess, Integer> loanidcloumn;

    @FXML
    private TextField loantypetextfield;

    @FXML
    private TableView<Approveprocess> tableview;
    @javafx.fxml.FXML
    public void initialize() {
        decissiongroupcombotextfield.getItems().addAll("Passed", "Fail", "Pending");
        loanidcloumn.setCellValueFactory(new PropertyValueFactory<Approveprocess, Integer>("loanid"));
        cidcloumn.setCellValueFactory(new PropertyValueFactory<Approveprocess, Integer>("clientid"));
        cnamecloumn.setCellValueFactory(new PropertyValueFactory<Approveprocess, String>("name"));
        applydatecloumn.setCellValueFactory(new PropertyValueFactory<Approveprocess, LocalDate>("loantypefield"));
        decissiongroupcloumn.setCellValueFactory(new PropertyValueFactory<Approveprocess, String>("decissiongroup"));


    }
    @FXML
    void addalldatbution(ActionEvent event) {

        tableview.getItems().clear();
        String name = cnametextfield.getText();
        int clientid = Integer.parseInt(cidtextfield.getText());
        int loanid = Integer.parseInt(loadidtextfield.getText());
        String loantype = loantypetextfield.getText();
        LocalDate loanapplydate = applydatepickertextfield.getValue();
        String decissiongroup = decissiongroupcombotextfield.getValue();

        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            f = new File("Approveprocess.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutPutStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            Approveprocess y = new Approveprocess(name,clientid,loanid,loantype,loanapplydate,decissiongroup);
            tableview.getItems().add(y);
            oos.writeObject(y);

        } catch (IOException ex) {
            Logger.getLogger(ApproveandrejectloanController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(ApproveandrejectloanController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void loadAll() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("Approveprocess.bin"));
            while (true) {
                try {
                    Approveprocess y = (Approveprocess) ois.readObject();
                    tableview.getItems().add(y);
                } catch (EOFException eof) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (ois != null) ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void backbution(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulation_of_retail_banking/Samad/Loan_Officer/loanofficerdashboard.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("LoanofficerdashboardController");
        window.setScene(scene2);
        window.show();

    }

    @FXML
    void showalldatabution(ActionEvent event) {
        tableview.getItems().clear();
        loadAll();

    }

}
