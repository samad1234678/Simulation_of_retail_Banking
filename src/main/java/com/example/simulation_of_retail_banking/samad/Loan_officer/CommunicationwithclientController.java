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

public class CommunicationwithclientController {

    @FXML
    private TableColumn<Communicationprocess, String> addresscloumn;

    @FXML
    private TextField adresstextfield;

    @FXML
    private DatePicker communicationdatetextfield;

    @FXML
    private TableColumn<Communicationprocess, Integer> contactcloumn;

    @FXML
    private TextField contacttextfield;

    @FXML
    private TableColumn<Communicationprocess, String> emailcloumnn;

    @FXML
    private TextField emailtetfield;

    @FXML
    private TableColumn<Communicationprocess, String> gendercloumn;

    @FXML
    private ComboBox<String> gendertextfield;

    @FXML
    private TableColumn<Communicationprocess, Integer> idcloumn;

    @FXML
    private TextField idtextfield;

    @FXML
    private TableColumn<Communicationprocess, String> namecloumn;

    @FXML
    private TextField nametextfield;

    @FXML
    private TableView<Communicationprocess> tableview;


    @javafx.fxml.FXML
    public void initialize() {
        gendertextfield.getItems().addAll("Male","Female","Other");
        namecloumn.setCellValueFactory(new PropertyValueFactory<Communicationprocess, String>("name"));
        idcloumn.setCellValueFactory(new PropertyValueFactory<Communicationprocess, Integer>("id"));
        contactcloumn.setCellValueFactory(new PropertyValueFactory<Communicationprocess,Integer>("contact"));
        emailcloumnn.setCellValueFactory(new PropertyValueFactory<Communicationprocess, String>("email"));
        addresscloumn.setCellValueFactory(new PropertyValueFactory<Communicationprocess, String>("adress"));
        gendercloumn.setCellValueFactory(new PropertyValueFactory<Communicationprocess, String>("clientgender"));
    }


    @FXML
    void addalldocumentbution(ActionEvent event) {
        tableview.getItems().clear();

        String name= nametextfield.getText();
        int id=Integer.parseInt(idtextfield.getText());
        int contact=Integer.parseInt(contacttextfield.getText());
        String email=emailtetfield.getText();
        String adress=adresstextfield.getText();
        LocalDate date=communicationdatetextfield.getValue();
        String gender=gendertextfield.getValue();



        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            f = new File("Communicationprocess.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutPutStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            Communicationprocess y = new Communicationprocess(email,name,id,contact,adress,date,gender);
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
            ois = new ObjectInputStream(new FileInputStream("Communicationprocess.bin"));
            while (true) {
                try {
                    Communicationprocess y = (Communicationprocess) ois.readObject();
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
    void showalldetailsbution(ActionEvent event) {
        loadAll();

    }

}
