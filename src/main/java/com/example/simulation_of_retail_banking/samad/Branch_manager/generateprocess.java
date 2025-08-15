package com.example.simulation_of_retail_banking.samad.Branch_manager;

import java.io.Serializable;
import java.time.LocalDate;

public class generateprocess implements Serializable {
    private String name;
    private int branchcode;
    private LocalDate reportstartdate;
    private  String reporttype;
    private LocalDate reportenddate;
    private String reportarea;

    public generateprocess(String name, int branchcode, LocalDate reportstartdate, String reporttype, LocalDate reportenddate, String reportarea) {
        this.name = name;
        this.branchcode = branchcode;
        this.reportstartdate = reportstartdate;
        this.reporttype = reporttype;
        this.reportenddate = reportenddate;
        this.reportarea = reportarea;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBranchcode() {
        return branchcode;
    }

    public void setBranchcode(int branchcode) {
        this.branchcode = branchcode;
    }

    public LocalDate getReportstartdate() {
        return reportstartdate;
    }

    public void setReportstartdate(LocalDate reportstartdate) {
        this.reportstartdate = reportstartdate;
    }

    public String getReporttype() {
        return reporttype;
    }

    public void setReporttype(String reporttype) {
        this.reporttype = reporttype;
    }

    public LocalDate getReportenddate() {
        return reportenddate;
    }

    public void setReportenddate(LocalDate reportenddate) {
        this.reportenddate = reportenddate;
    }

    public String getReportarea() {
        return reportarea;
    }

    public void setReportarea(String reportarea) {
        this.reportarea = reportarea;
    }

    @Override
    public String toString() {
        return "generateprocess{" +
                "name='" + name + '\'' +
                ", branchcode=" + branchcode +
                ", reportstartdate=" + reportstartdate +
                ", reporttype='" + reporttype + '\'' +
                ", reportenddate=" + reportenddate +
                ", reportarea='" + reportarea + '\'' +
                '}';
    }
}
