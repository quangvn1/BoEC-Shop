/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quangvn.models;

import com.quangvn.dao.CartDao;
import com.quangvn.model.Account;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author VAN
 */
public class Cart implements Cloneable {

    private int id;
    private Account acc;
    private List<ProductCart> listProduct;

    public Cart() {
    }

    public Cart(Account acc) {
        this.acc = acc;
        listProduct = new ArrayList<ProductCart>();
    }

    public Cart(Account acc, List<ProductCart> listProduct) {
        this.acc = acc;
        this.listProduct = listProduct;
    }

    public Account getAcc() {
        return acc;
    }

    public void setAcc(Account acc) {
        this.acc = acc;
    }

    public List<ProductCart> getListProduct() {
        return listProduct;
    }

    public void setListProduct(List<ProductCart> listProduct) {
        this.listProduct = listProduct;
    }

    public void addProductCart(ProductCart product) {
        listProduct.add(product);
    }

    public void updateProduct(ProductCart product) {
        for (ProductCart eleme : listProduct) {
            if (eleme.getProduct().getId() == product.getProduct().getId()) {
                eleme.setAmount(product.getAmount());
            }
        }
    }

    public void deleteProduct(int id) {
        Iterator<ProductCart> iter = listProduct.iterator();
        while (iter.hasNext()) {
            ProductCart ele = iter.next();
            if (ele.getProduct().getId() == id) {
                iter.remove();
            }
        }
    }

    public int getCost() {
        int result = 0;
        for (ProductCart eleme : listProduct) {
            result += eleme.getProduct().getPrice() * eleme.getAmount();
        }
        return result;
    }

    public int getTotalAmount() {
        int _amount = 0;
        for (ProductCart element : listProduct) {
            _amount += element.getAmount();
        }
        return _amount;
    }

    public void loadData(Bill bill, Account account) {
        this.listProduct = CartDao.getCurrentCart(bill, account);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        List<ProductCart> _list_temp = new ArrayList<ProductCart>();
        Account _acc_temp = this.acc;
        for (ProductCart element : this.listProduct) {
            _list_temp.add(element);
        }
        return new Cart(_acc_temp, _list_temp);
    }
}
