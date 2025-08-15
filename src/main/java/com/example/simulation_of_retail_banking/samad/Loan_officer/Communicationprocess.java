package com.example.simulation_of_retail_banking.samad.Loan_officer;

import com.example.simulation_of_retail_banking.User;

import java.io.Serializable;
import java.time.LocalDate;

public class Communicationprocess extends User implements Serializable {

    private String name;
    private int id;
    private int contact;
    private String adress;
    private LocalDate communicationdate;
    private String clientgender;

    public Communicationprocess(String email, String name, int id, int contact, String adress, LocalDate communicationdate, String clientgender) {
        super(email);
        this.name = name;
        this.id = id;
        this.contact = contact;
        this.adress = adress;
        this.communicationdate = communicationdate;
        this.clientgender = clientgender;
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

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public LocalDate getCommunicationdate() {
        return communicationdate;
    }

    public void setCommunicationdate(LocalDate communicationdate) {
        this.communicationdate = communicationdate;
    }

    public String getClientgender() {
        return clientgender;
    }

    public void setClientgender(String clientgender) {
        this.clientgender = clientgender;
    }

    @Override
    public String toString() {
        return "Communicationprocess{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", contact=" + contact +
                ", adress='" + adress + '\'' +
                ", communicationdate=" + communicationdate +
                ", clientgender='" + clientgender + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

