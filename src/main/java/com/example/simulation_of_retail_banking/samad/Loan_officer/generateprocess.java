package com.example.simulation_of_retail_banking.samad.Loan_officer;

import com.example.simulation_of_retail_banking.User;

import java.io.Serializable;
import java.time.LocalDate;

public class generateprocess extends User implements Serializable {

   private String name;
   private  int id;
   private String reporttype;
   private  String gender;
   private String loanreportname;
   private LocalDate reportdate;
   private String loanstatus;

    public generateprocess(String email, String name, int id, String reporttype, String gender, String loanreportname, LocalDate reportdate, String loanstatus) {
        super(email);
        this.name = name;
        this.id = id;
        this.reporttype = reporttype;
        this.gender = gender;
        this.loanreportname = loanreportname;
        this.reportdate = reportdate;
        this.loanstatus = loanstatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReporttype() {
        return reporttype;
    }

    public void setReporttype(String reporttype) {
        this.reporttype = reporttype;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLoanreportname() {
        return loanreportname;
    }

    public void setLoanreportname(String loanreportname) {
        this.loanreportname = loanreportname;
    }

    public LocalDate getReportdate() {
        return reportdate;
    }

    public void setReportdate(LocalDate reportdate) {
        this.reportdate = reportdate;
    }

    public String getLoanstatus() {
        return loanstatus;
    }

    public void setLoanstatus(String loanstatus) {
        this.loanstatus = loanstatus;
    }

    @Override
    public String toString() {
        return "generateprocess{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", reporttype='" + reporttype + '\'' +
                ", gender='" + gender + '\'' +
                ", loanreportname='" + loanreportname + '\'' +
                ", reportdate=" + reportdate +
                ", loanstatus='" + loanstatus + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
