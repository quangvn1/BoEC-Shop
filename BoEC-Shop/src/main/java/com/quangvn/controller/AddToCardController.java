/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quangvn.controller;

import com.quangvn.dao.BillDao;
import com.quangvn.dao.CartDao;
import com.quangvn.dao.ProductDao;
import com.quangvn.model.Account;
import com.quangvn.models.Bill;
import com.quangvn.models.Cart;
import com.quangvn.models.ProductCart;
import java.io.IOException;
import java.util.Calendar;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author VAN
 */
@Controller
@RequestMapping(value = "/addtocart")
public class AddToCardController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public void addToCart(HttpServletRequest request, HttpServletResponse response) throws IOException, CloneNotSupportedException {
        HttpSession session = request.getSession();
        Account user = (Account) session.getAttribute("user");
        Bill bill = BillDao.getBillNotPayByUser(user);
        String id_product = request.getParameter("id");
        int number = 1;
        Cart cart = new Cart(user);
        ProductCart product = null;
        if (bill == null) {
            Bill newBill = new Bill();
            Calendar today = Calendar.getInstance();
            newBill.setUser(user);
            newBill.setCreatedDate(today.getTime());
            newBill.setStatus(0);
            BillDao.createBill(newBill);
            newBill.setId(BillDao.getIdNewBill(newBill));
            CartDao.insertProductCart(Integer.parseInt(id_product), newBill, number);
            product = new ProductCart(ProductDao.getProductById(Integer.parseInt(id_product)), 1);
            cart.addProductCart(product);
        } else {
            cart = (Cart) session.getAttribute("cart");
            if (CartDao.checkExistProductCart(Integer.parseInt(id_product), bill.getId())) {
                int num = CartDao.getNumberProduct(Integer.parseInt(id_product), bill.getId()) + 1;
                CartDao.updateNumberProduct(Integer.parseInt(id_product), bill.getId(), num);
                product = new ProductCart(ProductDao.getProductById(Integer.parseInt(id_product)), num);
                cart.updateProduct(product);
            } else {
                new ProductCart(ProductDao.getProductById(Integer.parseInt(id_product)), 1);
                CartDao.insertProductCart(Integer.parseInt(id_product), bill, 1);
                cart.addProductCart(product);
            }
        }
        session.setAttribute("cart", cart.clone());
        response.sendRedirect("/BoEC-Shop/cart");
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public void addToCartPost(HttpServletRequest request, HttpServletResponse response) throws IOException, CloneNotSupportedException {
        HttpSession session = request.getSession();
        Account user = (Account) session.getAttribute("user");
        Bill bill = BillDao.getBillNotPayByUser(user);
        String id_product = request.getParameter("id");
        int number = Integer.parseInt((String) request.getParameter("number"));
        Cart cart = new Cart(user);
        ProductCart product = new ProductCart(ProductDao.getProductById(Integer.parseInt(id_product)), number);
        if (bill == null) {
            Bill newBill = new Bill();
            Calendar today = Calendar.getInstance();
            newBill.setUser(user);
            newBill.setCreatedDate(today.getTime());
            newBill.setStatus(0);
            BillDao.createBill(newBill);
            newBill.setId(BillDao.getIdNewBill(newBill));
            CartDao.insertProductCart(Integer.parseInt(id_product), newBill, number);
            cart.addProductCart(product);
        } else {
            cart = (Cart) session.getAttribute("cart");
            if (CartDao.checkExistProductCart(Integer.parseInt(id_product), bill.getId())) {
                int num = CartDao.getNumberProduct(Integer.parseInt(id_product), bill.getId()) + number;
                CartDao.updateNumberProduct(Integer.parseInt(id_product), bill.getId(), num);
                cart.updateProduct(product);
            } else {
                CartDao.insertProductCart(Integer.parseInt(id_product), bill, number);
                cart.addProductCart(product);
            }
        }
        session.setAttribute("cart", cart.clone());
        response.sendRedirect("/BoEC-Shop/cart");
    }

}
