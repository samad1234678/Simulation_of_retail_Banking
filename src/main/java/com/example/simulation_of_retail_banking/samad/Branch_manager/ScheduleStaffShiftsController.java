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

public class ScheduleStaffShiftsController {

    @FXML
    private TextField endtimetextfeld;

    @FXML
    private TableColumn<schedulwstafprocess, LocalDate> shiftdateclumn;

    @FXML
    private DatePicker shiftdatepicketfeld;

    @FXML
    private TableColumn<schedulwstafprocess, Integer> shiftendtimecolumn;

    @FXML
    private TableColumn<schedulwstafprocess, Integer> shiftstarttimecolumn;

    @FXML
    private ComboBox<String> shifttimecombofeld;

    @FXML
    private TableColumn<schedulwstafprocess, String> shifttypecolumn;

    @FXML
    private TableColumn<schedulwstafprocess, Integer> stafidcolum;

    @FXML
    private TextField stafidtextfeld;

    @FXML
    private TableColumn<schedulwstafprocess, String> stafnamecolumn;

    @FXML
    private TextField stafnametextfeld;

    @FXML
    private TextField starttimetextfeld;

    @FXML
    private TableView<schedulwstafprocess> tableview;





    @javafx.fxml.FXML
    public void initialize() {

        shifttimecombofeld.getItems().addAll("Morning","Evening","Night");
        stafidcolum.setCellValueFactory(new PropertyValueFactory<schedulwstafprocess, Integer>("id"));
        stafnamecolumn.setCellValueFactory(new PropertyValueFactory<schedulwstafprocess, String>("name"));
        shiftdateclumn.setCellValueFactory(new PropertyValueFactory<schedulwstafprocess, LocalDate>("shiftdate"));
        shiftstarttimecolumn.setCellValueFactory(new PropertyValueFactory<schedulwstafprocess, Integer>("siftstarttime"));
        shiftendtimecolumn.setCellValueFactory(new PropertyValueFactory<schedulwstafprocess, Integer>("shifrendtime"));
        shifttypecolumn.setCellValueFactory(new PropertyValueFactory<schedulwstafprocess, String>("type"));

    }


        @FXML
    void addalldatabution(ActionEvent event) {
        tableview.getItems().clear();


        int Stafid=Integer.parseInt(stafidtextfeld.getText());
        String name= stafnametextfeld.getText();
        LocalDate shiftdate= shiftdatepicketfeld.getValue();
        int starttime=Integer.parseInt(starttimetextfeld.getText());
        int endtime=Integer.parseInt(endtimetextfeld.getText());
        String shifttype=shifttimecombofeld.getValue();


        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            f = new File("schedulwstafprocess.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutPutStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            schedulwstafprocess y = new schedulwstafprocess(Stafid,name,shiftdate,starttime,endtime,shifttype);
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
            ois = new ObjectInputStream(new FileInputStream("schedulwstafprocess.bin"));
            while (true) {
                try {
                    schedulwstafprocess y = (schedulwstafprocess) ois.readObject();
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
    void backbution(ActionEvent event)   throws IOException {
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
