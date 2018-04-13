/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quangvn.model;

import java.io.Serializable;
import org.springframework.stereotype.Component;

/**
 *
 * @author VAN
 */
@Component
public abstract class Account{
    
    protected int id;
    protected String username;
    protected String password;
    protected String fullname;
    protected String gender;
    protected String email;
    protected String phone;
    protected String address;
    protected String desc;
    protected AbstractRole role;

    public Account() {
    }

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public Account(String username, String password, String fullname, String gender, String email, String phone, String address) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public abstract boolean isNull();
    public abstract String getUsername();
    public abstract String getPassword();
    public abstract String getFullname();
    public abstract String getGender();
    public abstract String getEmail();
    public abstract String getPhone();
    public abstract String getAddress();
    public abstract String getDesc();

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public void setDesc(String desc) {
        this.desc = desc;
    }

    public AbstractRole getRole() {
        return role;
    }
    
}
