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
public class AdminAccount extends RealAccount{
    
    public AdminAccount() {
        RoleCache.loadCache();
        role = RoleCache.getRole(RoleCache.ADMIN_ROLE);
    }
    
}
