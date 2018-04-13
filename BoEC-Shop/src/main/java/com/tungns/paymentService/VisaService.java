/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tungns.paymentService;

import com.quangvn.dao.BillDao;
import com.quangvn.dao.CardDao;
import com.quangvn.models.Bill;
import com.quangvn.models.Card;

/**
 *
 * @author nguye
 */
public class VisaService implements IPaymentService{
    private CardDao cardDAO = CardDao.getInstance();
    
    @Override
    public boolean checkExisted(Card card) {
        return cardDAO.checkExisted(card);
    }

    @Override
    public void pay(Card card, Bill bill) {
        if(!checkExisted(card)){
            cardDAO.insertCard(card);            
        }
        card.setId(cardDAO.getCardId(card));
        BillDao.updateBill(bill, card);
    }
}
