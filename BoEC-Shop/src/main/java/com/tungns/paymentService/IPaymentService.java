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
public interface IPaymentService {
    public boolean checkExisted(Card card);
    public void pay(Card card, Bill bill);
}
