package com.example.simulation_of_retail_banking;

import java.io.Serializable;

public class User implements Serializable {
    protected String email;

    public User(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
