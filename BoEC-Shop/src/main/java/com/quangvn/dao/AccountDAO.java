/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quangvn.dao;

import com.quangvn.factory.AccountFactory;
import com.quangvn.model.Account;
import com.quangvn.model.NullAccount;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author VAN
 */
public class AccountDAO extends BaseDao{
    
    public static Account checkAccount(String username, String password) {
        Connection con = getConnect();
        Account entity = new NullAccount();
        String sql = "SELECT a.username, a.password, a.fullname, a.gender, a.phone, a.address, a.email, a.paymentCardId, a.desc, a.roleId "
                + "FROM account a, role b "
                + "WHERE a.username = ? AND a.password = ? "
                + "AND a.roleId = b.id";
        PreparedStatement prs = null;
        try {
            prs = con.prepareStatement(sql);
            prs.setString(1, username);
            prs.setString(2, password);
            ResultSet rs = prs.executeQuery();
            if (rs.next()) {
                entity = AccountFactory.getAccount(rs);
                return entity;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return entity;
        }
        return entity;
    }
    
}
