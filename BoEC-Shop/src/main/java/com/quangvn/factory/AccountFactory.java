/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quangvn.factory;

import com.quangvn.model.Account;
import com.quangvn.model.AdminAccount;
import com.quangvn.model.CustomerAccount;
import com.quangvn.model.NullAccount;
import com.quangvn.model.RoleCache;
import java.sql.ResultSet;

/**
 *
 * @author VAN
 */
public class AccountFactory {

    public static Account getAccount(ResultSet rs) {
        try {
            String username = rs.getString("USERNAME");
            String password = rs.getString("PASSWORD");
            String fullname = rs.getString("FULLNAME");
            String gender = rs.getString("GENDER");
            String phone = rs.getString("PHONE");
            String address = rs.getString("ADDRESS");
            String email = rs.getString("EMAIL");
            String desc = rs.getString("DESC");
            int roleId = rs.getInt("ROLEID");

            if (username!=null || password!=null) {
                if (roleId == RoleCache.ADMIN_ROLE) {
                    AdminAccount acc = new AdminAccount();
                    acc.setUsername(username);
                    acc.setPassword(password);
                    acc.setFullname(fullname);
                    acc.setGender(gender);
                    acc.setPhone(phone);
                    acc.setAddress(address);
                    acc.setEmail(email);
                    acc.setDesc(desc);
                    return acc;
                } else {
                    if (roleId == RoleCache.CUSTOMER_ROLE) {
                        CustomerAccount acc = new CustomerAccount();
                        acc.setUsername(username);
                        acc.setPassword(password);
                        acc.setFullname(fullname);
                        acc.setGender(gender);
                        acc.setPhone(phone);
                        acc.setAddress(address);
                        acc.setEmail(email);
                        acc.setDesc(desc);
                        return acc;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new NullAccount();
        }
        return new NullAccount();
    }

}
