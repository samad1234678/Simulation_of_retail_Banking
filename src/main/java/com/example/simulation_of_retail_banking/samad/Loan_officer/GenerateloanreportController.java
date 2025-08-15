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

public class GenerateloanreportController {

    @FXML
    private TableColumn<generateprocess, LocalDate> datecloumn;

    @FXML
    private TableColumn<generateprocess, String> emailcloumn;

    @FXML
    private TextField emailtextfield;

    @FXML
    private ComboBox<String> gendercombotextfield;

    @FXML
    private TableColumn<generateprocess, Integer> idcloumn;

    @FXML
    private TextField idtextfield;

    @FXML
    private TextField loanreportnametextfield;

    @FXML
    private TableColumn<generateprocess, String> loanstatuscloumn;

    @FXML
    private ComboBox<String> loanstatustextfieldcombo;

    @FXML
    private TableColumn<generateprocess, String> namecloumn;

    @FXML
    private TextField nametextfield;

    @FXML
    private DatePicker reportdatetextfield;

    @FXML
    private TableColumn<generateprocess, String> reportnamecloumn;

    @FXML
    private TableColumn<generateprocess, String> reporttypecloumn;

    @FXML
    private TextField reporttypetextfield;

    @FXML
    private TableView<generateprocess> tableview;


    @javafx.fxml.FXML
    public void initialize() {
        gendercombotextfield.getItems().addAll("Male","Female","Other");
        loanstatustextfieldcombo.getItems().addAll("Car","Home","Business");
        namecloumn.setCellValueFactory(new PropertyValueFactory<generateprocess, String>("name"));
        idcloumn.setCellValueFactory(new PropertyValueFactory<generateprocess, Integer>("id"));
        reporttypecloumn.setCellValueFactory(new PropertyValueFactory<generateprocess, String>("reporttype"));
        datecloumn.setCellValueFactory(new PropertyValueFactory<generateprocess, LocalDate>("reporttype"));
        emailcloumn.setCellValueFactory(new PropertyValueFactory<generateprocess, String>("email"));
    }



        @FXML
    void addtoallbution(ActionEvent event) {
        tableview.getItems().clear();

        String name=nametextfield.getText();
        int id=Integer.parseInt(idtextfield.getText());
        String reporttype=reporttypetextfield.getText();
        String gender=gendercombotextfield.getValue();
        String loanreportname=loanreportnametextfield.getText();
        LocalDate reportdate=reportdatetextfield.getValue();
        String loanstatus=loanstatustextfieldcombo.getValue();
        String email=emailtextfield.getText();

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
            generateprocess y = new generateprocess(email,name,id,reporttype,gender,loanreportname,reportdate,loanstatus);
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
            ois = new ObjectInputStream(new FileInputStream("generateprocess.bin"));
            while (true) {
                try {
                    generateprocess y= (generateprocess) ois.readObject();
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
        loadAll();


    }

}
