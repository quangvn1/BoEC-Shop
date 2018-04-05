/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tungns.chain;

import com.quangvn.controller.RegistrationController;
import com.quangvn.dao.AccountDao;
import static com.tungns.chain.AbstractChecking.EMAIL;

/**
 *
 * @author nguye
 */
public class UsernameChecking extends AbstractChecking{

    public UsernameChecking(int level) {
        this.levelChecking = level;
    }  
    
    @Override
    protected void check(String data) {
        if(AccountDao.checkExistUser(data)){
            RegistrationController.arrayError[USERNAME] = true;
        }else{
            RegistrationController.arrayError[USERNAME] = false;
        }
    }
    
}
