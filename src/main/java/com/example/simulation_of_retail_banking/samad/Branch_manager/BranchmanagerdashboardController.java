package com.example.simulation_of_retail_banking.samad.Branch_manager;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class BranchmanagerdashboardController
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void scheduleExternalInspectionsbution(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulation_of_retail_banking/Samad/Branch_manager/scheduleextranalinspection.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("scheduleExternalInspectionsbution");
        window.setScene(scene2);
        window.show();
    }

    @javafx.fxml.FXML
    public void initiateMarketingCampaignsbution(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulation_of_retail_banking/Samad/Branch_manager/initiateMarketingCampaigns.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("initiateMarketingCampaignsbution");
        window.setScene(scene2);
        window.show();
    }

    @javafx.fxml.FXML
    public void settheBranchTargetbution(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulation_of_retail_banking/Samad/Branch_manager/settheBranchTargetbution.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("settheBranchTargetbution");
        window.setScene(scene2);
        window.show();
    }

    @javafx.fxml.FXML
    public void scheduleStaffShiftsbution(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulation_of_retail_banking/Samad/Branch_manager/scheduleStaffShifts.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("scheduleStaffShiftsbution");
        window.setScene(scene2);
        window.show();
    }

    @javafx.fxml.FXML
    public void generateBranchPerformanceReportsbution(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulation_of_retail_banking/Samad/Branch_manager/generateBranchPerformanceReports.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("generateBranchPerformanceReportsbution");
        window.setScene(scene2);
        window.show();
    }

    @javafx.fxml.FXML
    public void manageBranchBudgetbution(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulation_of_retail_banking/Samad/Branch_manager/manageBranchBudget.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("manageBranchBudgetbution");
        window.setScene(scene2);
        window.show();
    }

    @javafx.fxml.FXML
    public void transferEmployeesBetweenBranchesbution(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulation_of_retail_banking/Samad/Branch_manager/transferEmployeesBetweenBranches.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("transferEmployeesBetweenBranchesbution");
        window.setScene(scene2);
        window.show();
    }

    @javafx.fxml.FXML
    public void conductStaffTrainingbution(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulation_of_retail_banking/Samad/Branch_manager/conductStaffTraining.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("conductStaffTrainingbution");
        window.setScene(scene2);
        window.show();
    }
}