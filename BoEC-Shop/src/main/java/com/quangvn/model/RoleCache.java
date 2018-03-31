/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quangvn.model;

import java.util.HashMap;

/**
 *
 * @author VAN
 */
public class RoleCache {
    
    public static final int ADMIN_ROLE = 1;
    public static final int CUSTOMER_ROLE = 2;
    
    private static final HashMap<Integer, AbstractRole> roleMap = 
            new HashMap<Integer, AbstractRole>();
    
    public static void loadCache() {
        AdminRole admin = new AdminRole();
        roleMap.put(ADMIN_ROLE, admin);
        CustomerRole customer = new CustomerRole();
        roleMap.put(CUSTOMER_ROLE, customer);
    }
    
    public static AbstractRole getRole(int roleId) {
        AbstractRole cachedRole = roleMap.get(roleId);
        return (AbstractRole) cachedRole.clone();
    }
}
