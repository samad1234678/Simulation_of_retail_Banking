package com.example.simulation_of_retail_banking.samad.Loan_officer;

import com.example.simulation_of_retail_banking.User;

import java.io.Serializable;
import java.time.LocalDate;

public class updatecutomerprocess extends User implements Serializable {
    private String name;
    private int id;
    private LocalDate dateofbirth;
    private LocalDate date;
    private int phonenum;
    private String adress;
    private String gender;

    public updatecutomerprocess(String email, String name, int id, LocalDate dateofbirth, LocalDate date, int phonenum, String adress, String gender) {
        super(email);
        this.name = name;
        this.id = id;
        this.dateofbirth = dateofbirth;
        this.date = date;
        this.phonenum = phonenum;
        this.adress = adress;
        this.gender = gender;
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

    public LocalDate getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(LocalDate dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(int phonenum) {
        this.phonenum = phonenum;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "updatecutomerprocess{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", dateofbirth=" + dateofbirth +
                ", date=" + date +
                ", phonenum=" + phonenum +
                ", adress='" + adress + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}