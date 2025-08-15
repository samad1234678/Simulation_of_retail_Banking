package com.example.simulation_of_retail_banking.samad.Branch_manager;

import java.io.Serializable;
import java.time.LocalDate;

public class managebrachprocess implements Serializable {
    private String name;
    private int id;
    private LocalDate budgetdate;
    private String budgetmanager;
    private int budgetamount;
    private String budgettitle;

    public managebrachprocess(String name, int id, LocalDate budgetdate, String budgetmanager, int budgetamount, String budgettitle) {
        this.name = name;
        this.id = id;
        this.budgetdate = budgetdate;
        this.budgetmanager = budgetmanager;
        this.budgetamount = budgetamount;
        this.budgettitle = budgettitle;
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

    public LocalDate getBudgetdate() {
        return budgetdate;
    }

    public void setBudgetdate(LocalDate budgetdate) {
        this.budgetdate = budgetdate;
    }

    public String getBudgetmanager() {
        return budgetmanager;
    }

    public void setBudgetmanager(String budgetmanager) {
        this.budgetmanager = budgetmanager;
    }

    public int getBudgetamount() {
        return budgetamount;
    }

    public void setBudgetamount(int budgetamount) {
        this.budgetamount = budgetamount;
    }

    public String getBudgettitle() {
        return budgettitle;
    }

    public void setBudgettitle(String budgettitle) {
        this.budgettitle = budgettitle;
    }

    @Override
    public String toString() {
        return "managebrachprocess{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", budgetdate=" + budgetdate +
                ", budgetmanager='" + budgetmanager + '\'' +
                ", budgetamount=" + budgetamount +
                ", budgettitle='" + budgettitle + '\'' +
                '}';
    }
}