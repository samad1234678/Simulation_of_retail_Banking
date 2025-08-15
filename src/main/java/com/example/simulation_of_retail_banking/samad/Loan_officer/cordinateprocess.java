package com.example.simulation_of_retail_banking.samad.Loan_officer;

import com.example.simulation_of_retail_banking.User;

import java.io.Serializable;
import java.time.LocalDate;

public class cordinateprocess extends User implements Serializable {
   private String name;
   private int id;
   private  LocalDate meetingdate;
   private int meetingtime;
   private int contactnum;
   private String meetinglocation;
   private String branchlocation;

    public cordinateprocess(String email, String name, int id, LocalDate meetingdate, int meetingtime, int contactnum, String meetinglocation, String branchlocation) {
        super(email);
        this.name = name;
        this.id = id;
        this.meetingdate = meetingdate;
        this.meetingtime = meetingtime;
        this.contactnum = contactnum;
        this.meetinglocation = meetinglocation;
        this.branchlocation = branchlocation;
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

    public LocalDate getMeetingdate() {
        return meetingdate;
    }

    public void setMeetingdate(LocalDate meetingdate) {
        this.meetingdate = meetingdate;
    }

    public int getMeetingtime() {
        return meetingtime;
    }

    public void setMeetingtime(int meetingtime) {
        this.meetingtime = meetingtime;
    }

    public int getContactnum() {
        return contactnum;
    }

    public void setContactnum(int contactnum) {
        this.contactnum = contactnum;
    }

    public String getMeetinglocation() {
        return meetinglocation;
    }

    public void setMeetinglocation(String meetinglocation) {
        this.meetinglocation = meetinglocation;
    }

    public String getBranchlocation() {
        return branchlocation;
    }

    public void setBranchlocation(String branchlocation) {
        this.branchlocation = branchlocation;
    }

    @Override
    public String toString() {
        return "cordinateprocess{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", meetingdate=" + meetingdate +
                ", meetingtime=" + meetingtime +
                ", contactnum=" + contactnum +
                ", meetinglocation='" + meetinglocation + '\'' +
                ", branchlocation='" + branchlocation + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}