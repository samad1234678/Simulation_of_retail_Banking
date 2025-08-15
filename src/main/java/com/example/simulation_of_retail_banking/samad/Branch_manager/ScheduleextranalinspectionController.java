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

public class ScheduleextranalinspectionController {

    @FXML
    private ComboBox<String> inspectionaltypetextfield;

    @FXML
    private TableColumn<scheduleextranalprocess, LocalDate> inspectiondatecloumn;

    @FXML
    private DatePicker inspectiondatetextfield;

    @FXML
    private TableColumn<scheduleextranalprocess, Integer> inspectionfeecloumn;

    @FXML
    private TextField inspectionfeetextfield;

    @FXML
    private TableColumn<scheduleextranalprocess, Integer> inspectionidcloumn;

    @FXML
    private TextField inspectionidtextfield;

    @FXML
    private TextField inspectionreporttextfield;

    @FXML
    private TextField inspectionresulttextfield;

    @FXML
    private TableColumn<scheduleextranalprocess, String> inspectornamecloumn;

    @FXML
    private TextField inspectornametextfield;

    @FXML
    private TableColumn<scheduleextranalprocess, String> inspectorresultcloumn;

    @FXML
    private TableView<scheduleextranalprocess> tableview;



    @javafx.fxml.FXML
    public void initialize() {

        inspectionaltypetextfield.getItems().addAll("High", "Low", "Mid");
        inspectionidcloumn.setCellValueFactory(new PropertyValueFactory<scheduleextranalprocess, Integer>("id"));
        inspectiondatecloumn.setCellValueFactory(new PropertyValueFactory<scheduleextranalprocess, LocalDate>("date"));
        inspectornamecloumn.setCellValueFactory(new PropertyValueFactory<scheduleextranalprocess, String>("name"));
        inspectorresultcloumn.setCellValueFactory(new PropertyValueFactory<scheduleextranalprocess, String>("result"));
        inspectionfeecloumn.setCellValueFactory(new PropertyValueFactory<scheduleextranalprocess, Integer>("fee"));
    }

    @FXML
    void addallbution(ActionEvent event) {
        tableview.getItems().clear();
        int id=Integer.parseInt(inspectionidtextfield.getText());
        LocalDate date=inspectiondatetextfield.getValue();
        String inspectorname=inspectornametextfield.getText();
        String type=inspectionaltypetextfield.getValue();
        int fee=Integer.parseInt(inspectionfeetextfield.getText());
        String result=inspectionresulttextfield.getText();
        String report=inspectionreporttextfield.getText();



        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            f = new File("scheduleextranalprocess.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutPutStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            scheduleextranalprocess y = new scheduleextranalprocess(id,date,inspectorname,type,fee,result,report);
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
            ois = new ObjectInputStream(new FileInputStream("scheduleextranalprocess.bin"));
            while (true) {
                try {
                    scheduleextranalprocess y = (scheduleextranalprocess) ois.readObject();
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
    void showalldadabution(ActionEvent event) {
        loadAll();

    }

}
