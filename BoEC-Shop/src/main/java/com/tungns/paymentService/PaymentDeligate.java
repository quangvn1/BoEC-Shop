/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tungns.paymentService;

import com.quangvn.models.Bill;
import com.quangvn.models.Card;

/**
 *
 * @author nguye
 */
public class PaymentDeligate {
    private IPaymentService service;
    private PaymentLookupService lookup = new PaymentLookupService();
    private int serviceType;

    public void setServiceType(int serviceType) {
        this.serviceType = serviceType;
    }
    
    public void pay(Card card, Bill bill){
        lookup.getService(serviceType).pay(card, bill);
    }
}
