package com.example.netflix.Adapters;

import android.widget.EditText;

public class UserhelperClass {
    String username, password, plan, firstname, lastname, pnumber, vdate;

    public UserhelperClass(String username, String password, String planname, EditText fn, EditText ln, EditText mb) { }

    public UserhelperClass(String username, String password, String plan, String firstname, String lastname, String pnumber, String vdate) {
        this.username = username;
        this.password = password;
        this.plan = plan;
        this.firstname = firstname;
        this.lastname = lastname;
        this.pnumber = pnumber;
        this.vdate = vdate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPnumber() {
        return pnumber;
    }

    public void setPnumber(String pnumber) {
        this.pnumber = pnumber;
    }

    public String getVdate() {
        return vdate;
    }

    public void setVdate(String vdate) {
        this.vdate = vdate;
    }
}

