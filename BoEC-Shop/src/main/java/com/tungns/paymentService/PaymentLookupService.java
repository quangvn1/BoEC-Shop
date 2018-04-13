/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tungns.paymentService;

/**
 *
 * @author nguye
 */
public class PaymentLookupService {
    
    public IPaymentService getService(int type){
        if(type == 0){
            return new VisaService();
        }else if (type == 1){
            return new MasterCardService();
        }else if (type == 2){
            return new ATMService();
        }else{
            return null;
        }
    }
}
