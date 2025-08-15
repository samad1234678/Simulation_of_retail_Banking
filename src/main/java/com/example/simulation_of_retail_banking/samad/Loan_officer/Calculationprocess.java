package com.example.simulation_of_retail_banking.samad.Loan_officer;

import java.io.Serializable;
import java.time.LocalDate;

public class Calculationprocess implements Serializable {

    private String name;
    private int id;
    private int loamamount;
    private int annulintarest;
    private int loantermyear;
    private  int totalpayment;
    private  int totalintarest;
    private LocalDate loanstartdate;

    public Calculationprocess(String name, int id, int loamamount, int annulintarest, int loantermyear, int totalpayment, int totalintarest, LocalDate loanstartdate) {
        this.name = name;
        this.id = id;
        this.loamamount = loamamount;
        this.annulintarest = annulintarest;
        this.loantermyear = loantermyear;
        this.totalpayment = totalpayment;
        this.totalintarest = totalintarest;
        this.loanstartdate = loanstartdate;
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

    public int getLoamamount() {
        return loamamount;
    }

    public void setLoamamount(int loamamount) {
        this.loamamount = loamamount;
    }

    public int getAnnulintarest() {
        return annulintarest;
    }

    public void setAnnulintarest(int annulintarest) {
        this.annulintarest = annulintarest;
    }

    public int getLoantermyear() {
        return loantermyear;
    }

    public void setLoantermyear(int loantermyear) {
        this.loantermyear = loantermyear;
    }

    public int getTotalpayment() {
        return totalpayment;
    }

    public void setTotalpayment(int totalpayment) {
        this.totalpayment = totalpayment;
    }

    public int getTotalintarest() {
        return totalintarest;
    }

    public void setTotalintarest(int totalintarest) {
        this.totalintarest = totalintarest;
    }

    public LocalDate getLoanstartdate() {
        return loanstartdate;
    }

    public void setLoanstartdate(LocalDate loanstartdate) {
        this.loanstartdate = loanstartdate;
    }

    @Override
    public String toString() {
        return "Calculationprocess{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", loamamount=" + loamamount +
                ", annulintarest=" + annulintarest +
                ", loantermyear=" + loantermyear +
                ", totalpayment=" + totalpayment +
                ", totalintarest=" + totalintarest +
                ", loanstartdate=" + loanstartdate +
                '}';
    }
}
