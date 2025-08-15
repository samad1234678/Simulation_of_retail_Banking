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

public class GenerateBranchPerformanceReportsController {

    @FXML
    private TextField branchareatextfield;

    @FXML
    private TableColumn<generateprocess, Integer> branchcodecloumn;

    @FXML
    private TextField branchcodetextfield;

    @FXML
    private TextField branchnametextfield;

    @FXML
    private TableColumn<generateprocess, String> branchnmecloumn;

    @FXML
    private TableColumn<generateprocess, LocalDate> reportenddatecloumn;

    @FXML
    private DatePicker reportenddatetextfield;

    @FXML
    private TableColumn<generateprocess, LocalDate> reportstartdatecloumn;

    @FXML
    private DatePicker reportstarttextfield;

    @FXML
    private TableColumn<generateprocess, String> reporttypecloumn;

    @FXML
    private ComboBox<String> reporttypetextcombofield;

    @FXML
    private TableView<generateprocess> tableview;


    @javafx.fxml.FXML
    public void initialize() {

        reporttypetextcombofield.getItems().addAll("Normal","Lowest","medium");
        branchnmecloumn.setCellValueFactory(new PropertyValueFactory<generateprocess, String>("name"));
        branchcodecloumn.setCellValueFactory(new PropertyValueFactory<generateprocess, Integer>("branchcode"));
        reportstartdatecloumn.setCellValueFactory(new PropertyValueFactory<generateprocess, LocalDate>("reportstartdate"));
        reportenddatecloumn.setCellValueFactory(new PropertyValueFactory<generateprocess, LocalDate>("reportenddate"));
        reporttypecloumn.setCellValueFactory(new PropertyValueFactory<generateprocess, String>("reporttype"));


    }

        @FXML
    void addalldatabution(ActionEvent event) {

            tableview.getItems().clear();
            String name = branchnametextfield.getText();
            int branchcode = Integer.parseInt(branchcodetextfield.getText());
            LocalDate reportstartdate = reportstarttextfield.getValue();
            String reporttype = reporttypetextcombofield.getValue();
            LocalDate reportenddate = reportenddatetextfield.getValue();
            String brancharea = branchareatextfield.getText();


            File f = null;
            FileOutputStream fos = null;
            ObjectOutputStream oos = null;
            try {
                f = new File("generateprocess.bin");
                if (f.exists()) {
                    fos = new FileOutputStream(f, true);
                    oos = new AppendableObjectOutPutStream(fos);
                } else {
                    fos = new FileOutputStream(f);
                    oos = new ObjectOutputStream(fos);
                }
                generateprocess y = new generateprocess(name, branchcode, reportstartdate, reporttype, reportenddate, brancharea);
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
        public void loadAll () {
            ObjectInputStream ois = null;
            try {
                ois = new ObjectInputStream(new FileInputStream("generateprocess.bin"));
                while (true) {
                    try {
                        generateprocess y = (generateprocess) ois.readObject();
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
    void backbution(ActionEvent event)  throws IOException {
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
