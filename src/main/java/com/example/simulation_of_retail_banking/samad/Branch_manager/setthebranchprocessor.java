package com.example.simulation_of_retail_banking.samad.Branch_manager;

import java.io.Serializable;
import java.time.LocalDate;

public class setthebranchprocessor implements Serializable {
    private String name;
    private int amount;
    private LocalDate targetenddate;
    private String targetarea;
    private int branchid;
    private  LocalDate targetstartdate;
    private String targettype;

    public setthebranchprocessor(String name, int amount, LocalDate targetenddate, String targetarea, int branchid, LocalDate targetstartdate, String targettype) {
        this.name = name;
        this.amount = amount;
        this.targetenddate = targetenddate;
        this.targetarea = targetarea;
        this.branchid = branchid;
        this.targetstartdate = targetstartdate;
        this.targettype = targettype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public LocalDate getTargetenddate() {
        return targetenddate;
    }

    public void setTargetenddate(LocalDate targetenddate) {
        this.targetenddate = targetenddate;
    }

    public String getTargetarea() {
        return targetarea;
    }

    public void setTargetarea(String targetarea) {
        this.targetarea = targetarea;
    }

    public int getBranchid() {
        return branchid;
    }

    public void setBranchid(int branchid) {
        this.branchid = branchid;
    }

    public LocalDate getTargetstartdate() {
        return targetstartdate;
    }

    public void setTargetstartdate(LocalDate targetstartdate) {
        this.targetstartdate = targetstartdate;
    }

    public String getTargettype() {
        return targettype;
    }

    public void setTargettype(String targettype) {
        this.targettype = targettype;
    }

    @Override
    public String toString() {
        return "setthebranchprocessor{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                ", targetenddate=" + targetenddate +
                ", targetarea='" + targetarea + '\'' +
                ", branchid=" + branchid +
                ", targetstartdate=" + targetstartdate +
                ", targettype='" + targettype + '\'' +
                '}';
    }
}
