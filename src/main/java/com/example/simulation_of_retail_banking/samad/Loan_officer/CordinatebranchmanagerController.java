package com.example.simulation_of_retail_banking.samad.Loan_officer;

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

public class CordinatebranchmanagerController {

    @FXML
    private TextField branchlocationtextfield;

    @FXML
    private TextField contacttextfield;

    @FXML
    private TableColumn<cordinateprocess, String> emailcloumn;

    @FXML
    private TextField emailtextfield;

    @FXML
    private TableColumn<cordinateprocess, Integer> idcloumn;

    @FXML
    private TextField manageridtextfield;

    @FXML
    private TextField managernametextfeld;

    @FXML
    private TableColumn<cordinateprocess, LocalDate> meetingdatecloumn;

    @FXML
    private DatePicker meetingdatetextfielddatepicker;

    @FXML
    private TextField meetinglocationtextfield;

    @FXML
    private TextField meetingtimetextfield;

    @FXML
    private TableColumn<cordinateprocess, String> namecloumn;

    @FXML
    private TableView<cordinateprocess> tableview;


    @javafx.fxml.FXML
    public void initialize() {
        namecloumn.setCellValueFactory(new PropertyValueFactory<cordinateprocess, String>("name"));
        idcloumn.setCellValueFactory(new PropertyValueFactory<cordinateprocess, Integer>("id"));
        meetingdatecloumn.setCellValueFactory(new PropertyValueFactory<cordinateprocess, LocalDate>("meetingdate"));
        emailcloumn.setCellValueFactory(new PropertyValueFactory<cordinateprocess, String>("email"));
    }

    @FXML
    void addallbution(ActionEvent event)  {
        tableview.getItems().clear();

        String name= managernametextfeld.getText();
        int id=Integer.parseInt(manageridtextfield.getText());
        LocalDate meetingdate=meetingdatetextfielddatepicker.getValue();
        int meetingtime=Integer.parseInt(meetingtimetextfield.getText());
        int contact=Integer.parseInt(contacttextfield.getText());
        String email=emailtextfield.getText();
        String meetinglocation=meetinglocationtextfield.getText();
        String branchlocation= branchlocationtextfield.getText();


        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            f = new File("cordinateprocess.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutPutStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            cordinateprocess y = new cordinateprocess(email,name,id,meetingdate,meetingtime,contact,meetinglocation,branchlocation);
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
            ois = new ObjectInputStream(new FileInputStream("cordinateprocess.bin"));
            while (true) {
                try {
                    cordinateprocess y = (cordinateprocess) ois.readObject();
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
    void showalldatabution(ActionEvent event)  {

        loadAll();

    }

}
