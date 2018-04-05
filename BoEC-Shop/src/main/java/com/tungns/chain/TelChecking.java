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
public class TelChecking extends AbstractChecking{

    public TelChecking(int level) {
        this.levelChecking = level;
    }
    
    @Override
    protected void check(String data) {
        if(AccountDao.checkExistTel(data)){
            RegistrationController.arrayError[TEL] = true;
        }else{
            RegistrationController.arrayError[TEL] = false;
        }
    }
    
}
