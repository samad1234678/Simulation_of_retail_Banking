package com.example.simulation_of_retail_banking.samad.Branch_manager;

import java.io.Serializable;
import java.security.PrivateKey;
import java.time.LocalDate;

public class transferemployeprocess implements Serializable {
    private String clientname;
    private String employename;
    private  String Branchfrom;
    private String  branchto;
    private LocalDate transferdate;
    private int employeid;

    public transferemployeprocess(String clientname, String employename, String branchfrom, String branchto, LocalDate transferdate, int employeid) {
        this.clientname = clientname;
        this.employename = employename;
        this.Branchfrom = branchfrom;
        this.branchto = branchto;
        this.transferdate = transferdate;
        this.employeid = employeid;
    }

    public String getClientname() {
        return clientname;
    }

    public void setClientname(String clientname) {
        this.clientname = clientname;
    }

    public String getEmployename() {
        return employename;
    }

    public void setEmployename(String employename) {
        this.employename = employename;
    }

    public String getBranchfrom() {
        return Branchfrom;
    }

    public void setBranchfrom(String branchfrom) {
        Branchfrom = branchfrom;
    }

    public String getBranchto() {
        return branchto;
    }

    public void setBranchto(String branchto) {
        this.branchto = branchto;
    }

    public LocalDate getTransferdate() {
        return transferdate;
    }

    public void setTransferdate(LocalDate transferdate) {
        this.transferdate = transferdate;
    }

    public int getEmployeid() {
        return employeid;
    }

    public void setEmployeid(int employeid) {
        this.employeid = employeid;
    }

    @Override
    public String toString() {
        return "transferemployeprocess{" +
                "clientname='" + clientname + '\'' +
                ", employename='" + employename + '\'' +
                ", Branchfrom='" + Branchfrom + '\'' +
                ", branchto='" + branchto + '\'' +
                ", transferdate=" + transferdate +
                ", employeid=" + employeid +
                '}';
    }
}
