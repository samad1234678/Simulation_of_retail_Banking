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

public class ApplyloanController {

    @FXML
    private TextField Clientnametextfield;

    @FXML
    private TableColumn<Applyprocess, String> adresscloumn;

    @FXML
    private TextField adresstextfield;

    @FXML
    private TableColumn<Applyprocess, String> clientmailcloumn;

    @FXML
    private TableColumn<Applyprocess, String> clientnamecolumn;

    @FXML
    private TableColumn<Applyprocess, Integer> clientnidcloumn;

    @FXML
    private TextField clientnidtextfield;

    @FXML
    private TableColumn<Applyprocess, Integer> clientphonecloumn;

    @FXML
    private DatePicker dateofbirthtextfield;

    @FXML
    private TextField emailtextfield;

    @FXML
    private TableColumn<Applyprocess, String> gendercloumn;

    @FXML
    private ComboBox<String> gendercombotextfield;

    @FXML
    private TableColumn<Applyprocess, String> loantypecloumn;

    @FXML
    private ComboBox<String> loantypecombotextfield;

    @FXML
    private TextField phonetextfield;

    @FXML
    private TableView<Applyprocess> tableview;

    @javafx.fxml.FXML
    public void initialize() {
        gendercombotextfield.getItems().addAll("Male", "Female", "Other");
        loantypecombotextfield.getItems().addAll("Home", "Car", "Business");
        clientnamecolumn.setCellValueFactory(new PropertyValueFactory<Applyprocess, String>("name"));
        clientnidcloumn.setCellValueFactory(new PropertyValueFactory<Applyprocess, Integer>("nid"));
        clientphonecloumn.setCellValueFactory(new PropertyValueFactory<Applyprocess, Integer>("phonenumber"));
        clientmailcloumn.setCellValueFactory(new PropertyValueFactory<Applyprocess, String>("email"));
        gendercloumn.setCellValueFactory(new PropertyValueFactory<Applyprocess, String>("gender"));
        loantypecloumn.setCellValueFactory(new PropertyValueFactory<Applyprocess, String>("loantype"));
        adresscloumn.setCellValueFactory(new PropertyValueFactory<Applyprocess, String>("adress"));

    }

    @FXML
    void addalladatabution(ActionEvent event) {
        tableview.getItems().clear();
        String name = Clientnametextfield.getText();
        int nid = Integer.parseInt(clientnidtextfield.getText());
        int phone = Integer.parseInt(phonetextfield.getText());
        String email = emailtextfield.getText();
        String gender = gendercombotextfield.getValue();
        String lontype = loantypecombotextfield.getValue();
        String adress = adresstextfield.getText();
        LocalDate dateofbirth = dateofbirthtextfield.getValue();


        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            f = new File("Applyprocess.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutPutStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            Applyprocess y = new Applyprocess(email, name, nid, phone, gender, lontype, dateofbirth, adress);
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
            ois = new ObjectInputStream(new FileInputStream("Applyprocess.bin"));
            while (true) {
                try {
                    Applyprocess y = (Applyprocess) ois.readObject();
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


