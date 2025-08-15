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

public class ManageloanprotfolioController {

    @FXML
    private ComboBox<String> clientgendercombotext;

    @FXML
    private TextField clientidtextfield;

    @FXML
    private TableColumn<manageloanprocess, String> clientnamecloumn;

    @FXML
    private TextField clientnametextfield;

    @FXML
    private DatePicker datetextfield;

    @FXML
    private TextField intarestratetextfield;

    @FXML
    private TableColumn<manageloanprocess, Integer> loanamountcloumn;

    @FXML
    private TextField loanamounttextfield;

    @FXML
    private DatePicker loanenddatedatepeakertextfield;

    @FXML
    private TableColumn<manageloanprocess, Integer> loanidcloumn;

    @FXML
    private TextField loanidtextfield;

    @FXML
    private DatePicker loanstartdatepeakertextfield;

    @FXML
    private ComboBox<String> loantypecombotextfield;

    @FXML
    private TableColumn<manageloanprocess, LocalDate> startdatecloumn;

    @FXML
    private TableView<manageloanprocess> tableview;

    @javafx.fxml.FXML
    public void initialize() {

        loantypecombotextfield.getItems().addAll("Car","Home","Business");
        clientgendercombotext.getItems().addAll("Male","Female","Other");
        loanidcloumn.setCellValueFactory(new PropertyValueFactory<manageloanprocess, Integer>("id"));
        clientnamecloumn.setCellValueFactory(new PropertyValueFactory<manageloanprocess, String>("name"));
        loanamountcloumn.setCellValueFactory(new PropertyValueFactory<manageloanprocess, Integer>("loanamount"));
        startdatecloumn.setCellValueFactory(new PropertyValueFactory<manageloanprocess, LocalDate>("loanstartdate"));

    }





        @FXML
    void addallbution(ActionEvent event) {
            tableview.getItems().clear();

        int loanid=Integer.parseInt(loanidtextfield.getText());
        String clientname=clientnametextfield.getText();
        int Clientid=Integer.parseInt(clientidtextfield.getText());
        String loantype=loantypecombotextfield.getValue();
        String clientgender=clientgendercombotext.getValue();
        int loanamount=Integer.parseInt(loanamounttextfield.getText());
        LocalDate loanstartdate=loanstartdatepeakertextfield.getValue();
        LocalDate loanenddate= loanenddatedatepeakertextfield.getValue();
        int intarest= Integer.parseInt(intarestratetextfield.getText());
        LocalDate date=datetextfield.getValue();



        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            f = new File("manageloanprocess.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutPutStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            manageloanprocess y = new manageloanprocess(loanid,clientname,Clientid,loantype,clientgender,loanamount,loanstartdate,loanenddate,intarest,date);
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
                ois = new ObjectInputStream(new FileInputStream("manageloanprocess.bin"));
                while (true) {
                    try {
                        manageloanprocess y = (manageloanprocess) ois.readObject();
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
