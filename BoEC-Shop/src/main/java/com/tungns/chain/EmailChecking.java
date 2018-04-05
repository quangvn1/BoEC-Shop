/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tungns.chain;

import com.quangvn.controller.RegistrationController;
import com.quangvn.dao.AccountDao;

/**
 *
 * @author nguye
 */
public class EmailChecking extends AbstractChecking{

    public EmailChecking(int level) {
        this.levelChecking = level;
    }

    @Override
    protected void check(String data) {
        if(AccountDao.checkExistEmail(data)){
            RegistrationController.arrayError[EMAIL] = true;
        }else{
            RegistrationController.arrayError[EMAIL] = false;
        }
    }
    
}
