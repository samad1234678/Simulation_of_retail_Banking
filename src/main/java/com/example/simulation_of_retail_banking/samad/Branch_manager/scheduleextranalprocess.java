package com.example.simulation_of_retail_banking.samad.Branch_manager;

import java.io.Serializable;
import java.time.LocalDate;

public class scheduleextranalprocess implements Serializable {

    private int id;
    private LocalDate date;
    private String name;
    private String type;
    private int fee;
    private String result;
    private String report;

    public scheduleextranalprocess(int id, LocalDate date, String name, String type, int fee, String result, String report) {
        this.id = id;
        this.date = date;
        this.name = name;
        this.type = type;
        this.fee = fee;
        this.result = result;
        this.report = report;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    @Override
    public String toString() {
        return "scheduleextranalprocess{" +
                "id=" + id +
                ", date=" + date +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", fee=" + fee +
                ", result='" + result + '\'' +
                ", report='" + report + '\'' +
                '}';
    }
}
