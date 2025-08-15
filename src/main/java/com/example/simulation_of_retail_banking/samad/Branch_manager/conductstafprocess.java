package com.example.simulation_of_retail_banking.samad.Branch_manager;

import java.io.Serializable;
import java.time.LocalDate;

public class conductstafprocess implements Serializable {

    private String name;
    private int id;
    private LocalDate traningstartdate;
    private  int traningstarttime;
    private  String traningarea;
    private  LocalDate traningenddate;
    private String traningtype;

    public conductstafprocess(String name, int id, LocalDate traningstartdate, int traningstarttime, String traningarea, LocalDate traningenddate, String traningtype) {
        this.name = name;
        this.id = id;
        this.traningstartdate = traningstartdate;
        this.traningstarttime = traningstarttime;
        this.traningarea = traningarea;
        this.traningenddate = traningenddate;
        this.traningtype = traningtype;
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

    public LocalDate getTraningstartdate() {
        return traningstartdate;
    }

    public void setTraningstartdate(LocalDate traningstartdate) {
        this.traningstartdate = traningstartdate;
    }

    public int getTraningstarttime() {
        return traningstarttime;
    }

    public void setTraningstarttime(int traningstarttime) {
        this.traningstarttime = traningstarttime;
    }

    public String getTraningarea() {
        return traningarea;
    }

    public void setTraningarea(String traningarea) {
        this.traningarea = traningarea;
    }

    public LocalDate getTraningenddate() {
        return traningenddate;
    }

    public void setTraningenddate(LocalDate traningenddate) {
        this.traningenddate = traningenddate;
    }

    public String getTraningtype() {
        return traningtype;
    }

    public void setTraningtype(String traningtype) {
        this.traningtype = traningtype;
    }

    @Override
    public String toString() {
        return "conductstafprocess{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", traningstartdate=" + traningstartdate +
                ", traningstarttime=" + traningstarttime +
                ", traningarea='" + traningarea + '\'' +
                ", traningenddate=" + traningenddate +
                ", traningtype='" + traningtype + '\'' +
                '}';
    }
}