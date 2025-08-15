package com.example.simulation_of_retail_banking.samad.Loan_officer;

import com.example.simulation_of_retail_banking.User;

import java.io.Serializable;
import java.time.LocalDate;

public class Applyprocess extends User implements Serializable {

    private String name;
    private int nid;
    private int phonenumber;
    private String gender;
    private String loantype;
    private LocalDate dateofbirth;
    private String adress;

    public Applyprocess(String email, String name, int nid, int phonenumber, String gender, String loantype, LocalDate dateofbirth, String adress) {
        super(email);
        this.name = name;
        this.nid = nid;
        this.phonenumber = phonenumber;
        this.gender = gender;
        this.loantype = loantype;
        this.dateofbirth = dateofbirth;
        this.adress = adress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNid() {
        return nid;
    }

    public void setNid(int nid) {
        this.nid = nid;
    }

    public int getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLoantype() {
        return loantype;
    }

    public void setLoantype(String loantype) {
        this.loantype = loantype;
    }

    public LocalDate getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(LocalDate dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        return "Applyprocess{" +
                "name='" + name + '\'' +
                ", nid=" + nid +
                ", phonenumber=" + phonenumber +
                ", gender='" + gender + '\'' +
                ", loantype='" + loantype + '\'' +
                ", dateofbirth=" + dateofbirth +
                ", adress='" + adress + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

