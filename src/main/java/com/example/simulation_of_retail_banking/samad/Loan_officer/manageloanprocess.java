package com.example.simulation_of_retail_banking.samad.Loan_officer;

import java.io.Serializable;
import java.time.LocalDate;

public class manageloanprocess implements Serializable {
    private int id;
    private String name;
    private int Clientid;
    private String loantype;
    private String gender;
    private int loanamount;
    private LocalDate loanstartdate;
    private LocalDate loanenddate;
    private int intarestrate;
    private LocalDate date;

    public manageloanprocess(int id, String name, int clientid, String loantype, String gender, int loanamount, LocalDate loanstartdate, LocalDate loanenddate, int intarestrate, LocalDate date) {
        this.id = id;
        this.name = name;
        Clientid = clientid;
        this.loantype = loantype;
        this.gender = gender;
        this.loanamount = loanamount;
        this.loanstartdate = loanstartdate;
        this.loanenddate = loanenddate;
        this.intarestrate = intarestrate;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getClientid() {
        return Clientid;
    }

    public void setClientid(int clientid) {
        Clientid = clientid;
    }

    public String getLoantype() {
        return loantype;
    }

    public void setLoantype(String loantype) {
        this.loantype = loantype;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getLoanamount() {
        return loanamount;
    }

    public void setLoanamount(int loanamount) {
        this.loanamount = loanamount;
    }

    public LocalDate getLoanstartdate() {
        return loanstartdate;
    }

    public void setLoanstartdate(LocalDate loanstartdate) {
        this.loanstartdate = loanstartdate;
    }

    public LocalDate getLoanenddate() {
        return loanenddate;
    }

    public void setLoanenddate(LocalDate loanenddate) {
        this.loanenddate = loanenddate;
    }

    public int getIntarestrate() {
        return intarestrate;
    }

    public void setIntarestrate(int intarestrate) {
        this.intarestrate = intarestrate;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "manageloanprocess{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Clientid=" + Clientid +
                ", loantype='" + loantype + '\'' +
                ", gender='" + gender + '\'' +
                ", loanamount=" + loanamount +
                ", loanstartdate=" + loanstartdate +
                ", loanenddate=" + loanenddate +
                ", intarestrate=" + intarestrate +
                ", date=" + date +
                '}';
    }
}