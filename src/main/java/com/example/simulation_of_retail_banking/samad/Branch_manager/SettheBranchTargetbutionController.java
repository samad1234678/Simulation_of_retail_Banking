package com.example.simulation_of_retail_banking.samad.Branch_manager;

import com.example.simulation_of_retail_banking.samad.Loan_officer.AppendableObjectOutPutStream;
import com.example.simulation_of_retail_banking.samad.Loan_officer.ApplyloanController;
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

public class SettheBranchTargetbutionController {

    @FXML
    private TableColumn<setthebranchprocessor, Integer> Branchidcloumn;

    @FXML
    private TextField branchidtextfield;

    @FXML
    private TableColumn<setthebranchprocessor, String> branchnamecloumn;

    @FXML
    private TextField branchnametextfield;

    @FXML
    private TableView<setthebranchprocessor> tableview;

    @FXML
    private TableColumn<setthebranchprocessor, Integer> targetamnountcloumn;

    @FXML
    private TextField targetamounttextfield;

    @FXML
    private TableColumn<setthebranchprocessor, String> targetareacloumn;

    @FXML
    private TextField targetareatextfile;

    @FXML
    private TableColumn<setthebranchprocessor, LocalDate> targetenddatecloumn;

    @FXML
    private DatePicker targetenddatepickertextfield;

    @FXML
    private TableColumn<setthebranchprocessor, LocalDate> targetstartdatecloumn;

    @FXML
    private DatePicker targetstartdatetextfield;

    @FXML
    private TableColumn<setthebranchprocessor, String> targettypecloumn;

    @FXML
    private ComboBox<String> targettypetextfieldcombo;


    @javafx.fxml.FXML
    public void initialize() {
        targettypetextfieldcombo.getItems().addAll("High","Medim","Low");
        branchnamecloumn.setCellValueFactory(new PropertyValueFactory<setthebranchprocessor, String>("name"));
        targetamnountcloumn.setCellValueFactory(new PropertyValueFactory<setthebranchprocessor, Integer>("amount"));
        targetenddatecloumn.setCellValueFactory(new PropertyValueFactory<setthebranchprocessor, LocalDate>("targetenddate"));
        targetstartdatecloumn.setCellValueFactory(new PropertyValueFactory<setthebranchprocessor, LocalDate>("targetstartdate"));
        targettypecloumn.setCellValueFactory(new PropertyValueFactory<setthebranchprocessor, String>("targetstartdate"));
        Branchidcloumn.setCellValueFactory(new PropertyValueFactory<setthebranchprocessor, Integer>("branchid"));
        targetareacloumn.setCellValueFactory(new PropertyValueFactory<setthebranchprocessor, String>("targetarea"));
    }

    @FXML
    void addalldatbution(ActionEvent event) {
        tableview.getItems().clear();

        String name = branchnametextfield.getText();
        int amount = Integer.parseInt(targetamounttextfield.getText());
        LocalDate enddate = targetenddatepickertextfield.getValue();
        String area = targetareatextfile.getText();
        int branchid = Integer.parseInt(branchidtextfield.getText());
        LocalDate startdate = targetstartdatetextfield.getValue();
        String type = targettypetextfieldcombo.getValue();


        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            f = new File("setthebranchprocessor.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutPutStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            setthebranchprocessor y = new setthebranchprocessor(name, amount, enddate, area, branchid, startdate, type);
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
            ois = new ObjectInputStream(new FileInputStream("setthebranchprocessor.bin"));
            while (true) {
                try {
                    setthebranchprocessor y = (setthebranchprocessor) ois.readObject();
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
    void backbution(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulation_of_retail_banking/Samad/Branch_manager/branchmanagerdashboard.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("BranchmanagerdashboardController");
        window.setScene(scene2);
        window.show();

    }

    @FXML
    void showalldatabution(ActionEvent event) {

        loadAll();
    }

}
