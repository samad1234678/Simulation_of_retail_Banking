package com.example.simulation_of_retail_banking.samad.Branch_manager;

import java.io.Serializable;
import java.time.LocalDate;

public class schedulwstafprocess implements Serializable {
    private  int id;
    private String name;
    private LocalDate shiftdate;
    private int siftstarttime;
    private  int shifrendtime;
    private String type;

    public schedulwstafprocess(int id, String name, LocalDate shiftdate, int siftstarttime, int shifrendtime, String type) {
        this.id = id;
        this.name = name;
        this.shiftdate = shiftdate;
        this.siftstarttime = siftstarttime;
        this.shifrendtime = shifrendtime;
        this.type = type;
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

    public LocalDate getShiftdate() {
        return shiftdate;
    }

    public void setShiftdate(LocalDate shiftdate) {
        this.shiftdate = shiftdate;
    }

    public int getSiftstarttime() {
        return siftstarttime;
    }

    public void setSiftstarttime(int siftstarttime) {
        this.siftstarttime = siftstarttime;
    }

    public int getShifrendtime() {
        return shifrendtime;
    }

    public void setShifrendtime(int shifrendtime) {
        this.shifrendtime = shifrendtime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "schedulwstafprocess{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shiftdate=" + shiftdate +
                ", siftstarttime=" + siftstarttime +
                ", shifrendtime=" + shifrendtime +
                ", type='" + type + '\'' +
                '}';
    }
}
