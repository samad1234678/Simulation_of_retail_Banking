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

public class TransferEmployeesBetweenBranchesController {

    @FXML
    private TableColumn<transferemployeprocess, String> branchfromcloumn;

    @FXML
    private TextField branchfromtextfield;

    @FXML
    private TableColumn<transferemployeprocess, String> branchtocloumn;

    @FXML
    private TextField branchtotextfield;

    @FXML
    private TableColumn<transferemployeprocess, String> clientnamecloumn;

    @FXML
    private TextField clientnametextfield;

    @FXML
    private TableColumn<transferemployeprocess, Integer> employeecloumn;

    @FXML
    private TextField employeeidtextfield;

    @FXML
    private TableColumn<transferemployeprocess, String> employeenamecloumn;

    @FXML
    private TextField employeenametextfield;

    @FXML
    private TableView<transferemployeprocess> tableview;

    @FXML
    private TableColumn<transferemployeprocess, LocalDate> transferdatecloumn;

    @FXML
    private DatePicker transferdatepeekertextfield;

    @javafx.fxml.FXML
    public void initialize() {
        clientnamecloumn.setCellValueFactory(new PropertyValueFactory<transferemployeprocess, String>("clientname"));
        employeenamecloumn.setCellValueFactory(new PropertyValueFactory<transferemployeprocess, String>("employename"));
        branchfromcloumn.setCellValueFactory(new PropertyValueFactory<transferemployeprocess, String>("Branchfrom"));
        branchtocloumn.setCellValueFactory(new PropertyValueFactory<transferemployeprocess, String>("branchto"));
        transferdatecloumn.setCellValueFactory(new PropertyValueFactory<transferemployeprocess, LocalDate>("transferdate"));
        employeecloumn.setCellValueFactory(new PropertyValueFactory<transferemployeprocess, Integer>("employeid"));

    }


    @FXML
    void addallbution(ActionEvent event) {

        tableview.getItems().clear();

        String clientname = clientnametextfield.getText();
        String Employename = employeeidtextfield.getText();
        String branchfrom = branchfromtextfield.getText();
        String branchto = branchtotextfield.getText();
        LocalDate transferdate = transferdatepeekertextfield.getValue();
        int employeeid = Integer.parseInt(employeeidtextfield.getText());


        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            f = new File("transferemployeprocess.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutPutStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            transferemployeprocess y = new transferemployeprocess(clientname, Employename, branchfrom, branchto, transferdate, employeeid);
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
            ois = new ObjectInputStream(new FileInputStream("transferemployeprocess.bin"));
            while (true) {
                try {
                    transferemployeprocess y = (transferemployeprocess) ois.readObject();
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
    void alertbution(ActionEvent event) {

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
        tableview.getItems().clear();

        loadAll();

    }

}
