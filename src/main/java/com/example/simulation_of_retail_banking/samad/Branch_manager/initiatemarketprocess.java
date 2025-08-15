package com.example.simulation_of_retail_banking.samad.Branch_manager;

import java.io.Serializable;
import java.security.PrivateKey;
import java.time.LocalDate;

public class initiatemarketprocess implements Serializable {
    private String name;
    private String area;
    private LocalDate startdate;
    private String camptype;
    private  LocalDate endtime;
    private String tagetaudiance;

    public initiatemarketprocess(String name, String area, LocalDate startdate, String camptype, LocalDate endtime, String tagetaudiance) {
        this.name = name;
        this.area = area;
        this.startdate = startdate;
        this.camptype = camptype;
        this.endtime = endtime;
        this.tagetaudiance = tagetaudiance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public LocalDate getStartdate() {
        return startdate;
    }

    public void setStartdate(LocalDate startdate) {
        this.startdate = startdate;
    }

    public String getCamptype() {
        return camptype;
    }

    public void setCamptype(String camptype) {
        this.camptype = camptype;
    }

    public LocalDate getEndtime() {
        return endtime;
    }

    public void setEndtime(LocalDate endtime) {
        this.endtime = endtime;
    }

    public String getTagetaudiance() {
        return tagetaudiance;
    }

    public void setTagetaudiance(String tagetaudiance) {
        this.tagetaudiance = tagetaudiance;
    }

    @Override
    public String toString() {
        return "initiatemarketprocess{" +
                "name='" + name + '\'' +
                ", area='" + area + '\'' +
                ", startdate=" + startdate +
                ", camptype='" + camptype + '\'' +
                ", endtime=" + endtime +
                ", tagetaudiance='" + tagetaudiance + '\'' +
                '}';
    }
}
