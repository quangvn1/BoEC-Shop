/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tungns.chain;

import com.quangvn.model.Account;

/**
 *
 * @author nguye
 */
public abstract class AbstractChecking {
    public static final int USERNAME = 0;
    public static final int EMAIL = 1;
    public static final int TEL = 2;
    
    protected AbstractChecking nextCheck;
    
    public int levelChecking;
    
    public void setNextCheck(AbstractChecking nextCheck){
        this.nextCheck = nextCheck;
    }
    
    public void checkAccount(int level, Account account){
        if(this.levelChecking <= level){
            if(this.levelChecking == USERNAME){
                check(account.getUsername());               
            }
            if(this.levelChecking == EMAIL){
                check(account.getEmail());
            }
            if(this.levelChecking == TEL){
                check(account.getPhone());
            }
        }
        if(nextCheck != null){
            nextCheck.checkAccount(level, account);
        }
    }

    protected abstract void check(String data);
    
}
