module com.example.simulation_of_retail_banking {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;


    opens com.example.simulation_of_retail_banking to javafx.fxml;
    exports com.example.simulation_of_retail_banking;
    opens com.example.simulation_of_retail_banking.samad.Branch_manager;
    exports com.example.simulation_of_retail_banking.samad.Branch_manager to javafx.fxml;
    opens com.example.simulation_of_retail_banking.samad.Loan_officer;
    exports com.example.simulation_of_retail_banking.samad.Loan_officer to javafx.fxml;







}