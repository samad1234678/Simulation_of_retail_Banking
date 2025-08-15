package com.example.simulation_of_retail_banking.samad.Loan_officer;

import java.io.Serializable;
import java.time.LocalDate;

public class Approveprocess implements  Serializable {
    private String name;
    private int  clientid;
    private int loanid;
    private String loantypefield;
    private LocalDate loanapplydate;
    private String decissiongroup;

    public Approveprocess(String name, int clientid, int loanid, String loantypefield, LocalDate loanapplydate, String decissiongroup) {
        this.name = name;
        this.clientid = clientid;
        this.loanid = loanid;
        this.loantypefield = loantypefield;
        this.loanapplydate = loanapplydate;
        this.decissiongroup = decissiongroup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getClientid() {
        return clientid;
    }

    public void setClientid(int clientid) {
        this.clientid = clientid;
    }

    public int getLoanid() {
        return loanid;
    }

    public void setLoanid(int loanid) {
        this.loanid = loanid;
    }

    public String getLoantypefield() {
        return loantypefield;
    }

    public void setLoantypefield(String loantypefield) {
        this.loantypefield = loantypefield;
    }

    public LocalDate getLoanapplydate() {
        return loanapplydate;
    }

    public void setLoanapplydate(LocalDate loanapplydate) {
        this.loanapplydate = loanapplydate;
    }

    public String getDecissiongroup() {
        return decissiongroup;
    }

    public void setDecissiongroup(String decissiongroup) {
        this.decissiongroup = decissiongroup;
    }

    @Override
    public String toString() {
        return "Approveprocess{" +
                "name='" + name + '\'' +
                ", clientid=" + clientid +
                ", loanid=" + loanid +
                ", loantypefield='" + loantypefield + '\'' +
                ", loanapplydate=" + loanapplydate +
                ", decissiongroup='" + decissiongroup + '\'' +
                '}';
    }
}
