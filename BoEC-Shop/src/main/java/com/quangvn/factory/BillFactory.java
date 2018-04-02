/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quangvn.factory;

import com.quangvn.model.Account;
import com.quangvn.model.CustomerAccount;
import com.quangvn.models.Bill;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author VAN
 */
public class BillFactory {
    
    public static Bill createBill(ResultSet rs) throws SQLException {
        Bill entity = new Bill();
        Account user = new CustomerAccount();
        user.setUsername(rs.getString("USERNAME"));
        entity.setId(rs.getInt("ID"));
        entity.setUser(user);
        entity.setCreatedDate(rs.getDate("CREATED_DATE"));
        entity.setPayDate(rs.getDate("PAY_DATE"));
        entity.setStatus(rs.getInt("STATUS"));
        return entity;
    }
    
}
