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

public class InitiateMarketingCampaignsController {

    @FXML
    private TableColumn<initiatemarketprocess, String> Targetaudiancecloumn;

    @FXML
    private TextField branchareatextfield;

    @FXML
    private TableColumn<initiatemarketprocess, String> campareacloumn;

    @FXML
    private TextField campareatextfield;

    @FXML
    private TableColumn<initiatemarketprocess, String> campingnamecloumn;

    @FXML
    private TextField campingnametextfield;

    @FXML
    private ComboBox<String> campingtimecombotextfield;

    @FXML
    private TableColumn<initiatemarketprocess, String> campingtipecloumn;

    @FXML
    private DatePicker enddatetextfield;

    @FXML
    private TableColumn<initiatemarketprocess, LocalDate> startdatecloumn;

    @FXML
    private DatePicker startdatepeekertextfield;

    @FXML
    private TableView<initiatemarketprocess> tableview;



    @javafx.fxml.FXML
    public void initialize() {
        campingtimecombotextfield.getItems().addAll("Higher","Lower","Medium");
        campingnamecloumn.setCellValueFactory(new PropertyValueFactory<initiatemarketprocess, String>("name"));
        campareacloumn.setCellValueFactory(new PropertyValueFactory<initiatemarketprocess, String>("area"));
        startdatecloumn.setCellValueFactory(new PropertyValueFactory<initiatemarketprocess, LocalDate>("startdate"));
        campingtipecloumn.setCellValueFactory(new PropertyValueFactory<initiatemarketprocess, String>("camptype"));
        Targetaudiancecloumn.setCellValueFactory(new PropertyValueFactory<initiatemarketprocess, String>("tagetaudiance"));
    }


        @FXML
    void addalldatabution(ActionEvent event) {

        tableview.getItems().clear();

        String name=campingnametextfield.getText();
        String area=campareatextfield.getText();
        LocalDate startdate=startdatepeekertextfield.getValue();
        String campingtype=campingtimecombotextfield.getValue();
        LocalDate enddate=enddatetextfield.getValue();
        String targetaudiance=branchareatextfield.getText();



        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            f = new File("initiatemarketprocess.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutPutStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            initiatemarketprocess y = new initiatemarketprocess(name,area,startdate,campingtype,enddate,targetaudiance);
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
            ois = new ObjectInputStream(new FileInputStream("initiatemarketprocess.bin"));
            while (true) {
                try {
                    initiatemarketprocess y = (initiatemarketprocess) ois.readObject();
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
        tableview.getItems().clear();
        loadAll();

    }

}
