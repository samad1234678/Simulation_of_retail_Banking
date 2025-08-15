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

import javax.lang.model.element.NestingKind;
import java.io.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UpdatecustomerinformationController {

    @FXML
    private TableColumn<updatecutomerprocess, String> adresscloumn;

    @FXML
    private TextField adresstextfield;

    @FXML
    private TextField cidtextfield;

    @FXML
    private TableColumn<updatecutomerprocess, String> cnamecloumn;

    @FXML
    private TextField cnametextfield;

    @FXML
    private TableColumn<updatecutomerprocess, Integer> contactcloumn;

    @FXML
    private DatePicker dateofbirthdatepickertextfield;

    @FXML
    private DatePicker datetextfield;

    @FXML
    private TextField emailtextfield;

    @FXML
    private TableColumn<updatecutomerprocess, String> gendercloumn;

    @FXML
    private ComboBox<String> gendercombotextfield;

    @FXML
    private TableColumn<updatecutomerprocess, Integer> idcloumn;

    @FXML
    private TextField numtextfield;

    @FXML
    private TableView<updatecutomerprocess> tableview;

    @javafx.fxml.FXML
    public void initialize() {
        gendercombotextfield.getItems().addAll("Male","Female","Other");
        cnamecloumn.setCellValueFactory(new PropertyValueFactory<updatecutomerprocess, String>("name"));
        idcloumn.setCellValueFactory(new PropertyValueFactory<updatecutomerprocess, Integer>("id"));
        gendercloumn.setCellValueFactory(new PropertyValueFactory<updatecutomerprocess, String>("gender"));
        adresscloumn.setCellValueFactory(new PropertyValueFactory<updatecutomerprocess, String>("adress"));
        contactcloumn.setCellValueFactory(new PropertyValueFactory<updatecutomerprocess, Integer>("phone"));
    }

        @FXML
    void addallbution(ActionEvent event) {
            tableview.getItems().clear();
            String name = cnametextfield.getText();
            int id = Integer.parseInt(cidtextfield.getText());
            LocalDate dateofbirth = dateofbirthdatepickertextfield.getValue();
            LocalDate date = datetextfield.getValue();
            int phonenum = Integer.parseInt(numtextfield.getText());
            String adress = adresstextfield.getText();
            String email = emailtextfield.getText();
            String gender = gendercombotextfield.getValue();

            File f = null;
            FileOutputStream fos = null;
            ObjectOutputStream oos = null;
            try {
                f = new File("updatecutomerprocess.bin");
                if (f.exists()) {
                    fos = new FileOutputStream(f, true);
                    oos = new AppendableObjectOutPutStream(fos);
                } else {
                    fos = new FileOutputStream(f);
                    oos = new ObjectOutputStream(fos);
                }
                updatecutomerprocess y = new updatecutomerprocess( email,name,id,dateofbirth,date,phonenum,adress,gender);
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
            ois = new ObjectInputStream(new FileInputStream("updatecutomerprocess.bin"));
            while (true) {
                try {
                    updatecutomerprocess y= (updatecutomerprocess) ois.readObject();
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
        tableview.getItems().clear();
        loadAll();

    }

}
