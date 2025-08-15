package com.example.simulation_of_retail_banking.samad.Branch_manager;

import com.example.simulation_of_retail_banking.samad.Loan_officer.AppendableObjectOutPutStream;
import com.example.simulation_of_retail_banking.samad.Loan_officer.ApplyloanController;
import com.example.simulation_of_retail_banking.samad.Loan_officer.Applyprocess;
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

public class ConductStaffTrainingController {

    @FXML
    private TableColumn<conductstafprocess, Integer> stafidcloumn;

    @FXML
    private TextField stafidtextfield;

    @FXML
    private TableColumn<conductstafprocess, String> stafnamecloumn;

    @FXML
    private TextField stafnametextfield;

    @FXML
    private TableView<conductstafprocess> tableview;

    @FXML
    private TableColumn<conductstafprocess, String> trainingenddatecloumn;

    @FXML
    private TableColumn<conductstafprocess, LocalDate> trainingstartdatecloumn;

    @FXML
    private ComboBox<String> trainingtypetextfiled;

    @FXML
    private TextField traningareatextfield;

    @FXML
    private DatePicker traningenddatefield;

    @FXML
    private TableColumn<conductstafprocess, String> traningtypecloumn;

    @FXML
    private DatePicker tsatartdatetextfield;

    @FXML
    private TextField tstarttimetextfield;


    @javafx.fxml.FXML
    public void initialize() {
        trainingtypetextfiled.getItems().addAll("Local", "Higher", "Medium");
        stafnamecloumn.setCellValueFactory(new PropertyValueFactory<conductstafprocess, String>("name"));
        stafidcloumn.setCellValueFactory(new PropertyValueFactory<conductstafprocess, Integer>("id"));
        trainingstartdatecloumn.setCellValueFactory(new PropertyValueFactory<conductstafprocess, LocalDate>("traningstartdate"));
        trainingenddatecloumn.setCellValueFactory(new PropertyValueFactory<conductstafprocess, String>("traningenddate"));
        traningtypecloumn.setCellValueFactory(new PropertyValueFactory<conductstafprocess, String>("traningtype"));

    }

    @FXML
    void addalldatbution(ActionEvent event) {
        tableview.getItems().clear();
        String name = stafnametextfield.getText();
        int id = Integer.parseInt(stafidtextfield.getText());
        LocalDate traningstartdate = tsatartdatetextfield.getValue();
        int traningstarttime = Integer.parseInt(tstarttimetextfield.getText());
        String traningarea = traningareatextfield.getText();
        LocalDate traningenddate = traningenddatefield.getValue();
        String traningtype = trainingtypetextfiled.getValue();


        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            f = new File("conductstafprocess.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutPutStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            conductstafprocess y = new conductstafprocess(name,id,traningstartdate,traningstarttime,traningarea,traningenddate,traningtype);
            tableview.getItems().add(y);
            oos.writeObject(y);

        } catch (IOException ex) {
            Logger.getLogger(ApplyloanController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(ApplyloanController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void loadAll() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("conductstafprocess.bin"));
            while (true) {
                try {
                    conductstafprocess y = (conductstafprocess) ois.readObject();
                    tableview.getItems().add(y);
                } catch (EOFException eof) {
                    break; // End of file reached, stop reading
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
    void backbution (ActionEvent event)  throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulation_of_retail_banking/Samad/Branch_manager/branchmanagerdashboard.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("BranchmanagerdashboardController");
        window.setScene(scene2);
        window.show();


    }

    @FXML
    void showalldatabution (ActionEvent event) {

        tableview.getItems().clear();
        loadAll();



        }
    }
