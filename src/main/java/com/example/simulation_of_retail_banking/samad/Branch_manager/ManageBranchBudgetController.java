package com.example.simulation_of_retail_banking.samad.Branch_manager;

import com.example.simulation_of_retail_banking.samad.Loan_officer.AppendableObjectOutPutStream;
import com.example.simulation_of_retail_banking.samad.Loan_officer.ApplyloanController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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

public class ManageBranchBudgetController {

    @FXML
    private TableColumn<managebrachprocess, Integer> budgetamountcloumn;

    @FXML
    private TextField budgetamounttextfield;

    @FXML
    private TableColumn<managebrachprocess, LocalDate> budgetdatecloumn;

    @FXML
    private DatePicker budgetdatetextfield;

    @FXML
    private TableColumn<managebrachprocess, Integer> budgetidcloumn;

    @FXML
    private TextField budgetidtextfield;

    @FXML
    private TableColumn<managebrachprocess, String> budgetmanagercloumn;

    @FXML
    private TextField budgetmanagertextfield;

    @FXML
    private TableColumn<managebrachprocess, String> budgetnamecloumn;

    @FXML
    private TextField budgetnametextfield;

    @FXML
    private TextField budgettitletextfield;

    @FXML
    private TableView<managebrachprocess> tableview;

    @javafx.fxml.FXML
    public void initialize() {

        budgetnamecloumn.setCellValueFactory(new PropertyValueFactory<managebrachprocess, String>("name"));
        budgetidcloumn.setCellValueFactory(new PropertyValueFactory<managebrachprocess, Integer>("id"));
        budgetdatecloumn.setCellValueFactory(new PropertyValueFactory<managebrachprocess, LocalDate>("budgetdate"));
        budgetmanagercloumn.setCellValueFactory(new PropertyValueFactory<managebrachprocess, String>("budgetmanager"));
        budgetamountcloumn.setCellValueFactory(new PropertyValueFactory<managebrachprocess, Integer>("budgetamount"));

    }
    @FXML
    void addalldatabution(ActionEvent event) {
        tableview.getItems().clear();
        String name=budgetnametextfield.getText();
        int id=Integer.parseInt(budgetidtextfield.getText());
        LocalDate budgetdate=budgetdatetextfield.getValue();
        String budgetmannager=budgetmanagertextfield.getText();
        int budgetamount=Integer.parseInt(budgetamounttextfield.getText());
        String budgedtitle=budgettitletextfield.getText();

        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            f = new File("managebrachprocess.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutPutStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            managebrachprocess y = new managebrachprocess(name,id,budgetdate,budgetmannager,budgetamount,budgedtitle);
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
            ois = new ObjectInputStream(new FileInputStream("managebrachprocess.bin"));
            while (true) {
                try {
                    managebrachprocess y = (managebrachprocess) ois.readObject();
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
