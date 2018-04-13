/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quangvn.model;

/**
 *
 * @author VAN
 */
public class NullAccount extends Account{

    @Override
    public boolean isNull() {
        return true;
    }

    @Override
    public String getUsername() {
        return "Invalid account";
    }

    @Override
    public String getPassword() {
        return "Invalid account";
    }

    @Override
    public String getFullname() {
        return "Invalid account";
    }

    @Override
    public String getGender() {
        return "Invalid account";
    }

    @Override
    public String getEmail() {
        return "Invalid account";
    }

    @Override
    public String getPhone() {
        return "Invalid account";
    }

    @Override
    public String getAddress() {
        return "Invalid account";
    }

    @Override
    public String getDesc() {
        return "Invalid account";
    }
    
}
