/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quangvn.controller;

import com.quangvn.dao.BillDao;
import com.quangvn.dao.CartDao;
import com.quangvn.model.Account;
import com.quangvn.model.NullAccount;
import com.quangvn.models.Bill;
import com.quangvn.models.Cart;
import com.quangvn.models.ProductCart;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author VAN
 */
@Controller
public class CartController {

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String doCart(HttpSession session, Model model) throws CloneNotSupportedException {
        Account user = (Account) session.getAttribute("user");
        Cart cart = (Cart) session.getAttribute("cart");
        Bill bill = BillDao.getBillNotPayByUser(user);
        List<ProductCart> listProduct = new ArrayList<>();
        if (bill != null) {
            cart.loadData(bill);
            listProduct = cart.getListProduct();
            int amount = cart.getCost();
            model.addAttribute("amount", amount);
        }
        if (listProduct.size() == 0) {
            model.addAttribute("msg", "Quý khách chưa có sản phẩm nào trong giỏ hàng");
        }
        model.addAttribute("listProduct", listProduct);
        return "cart/cart";
    }

    @RequestMapping(value = "/deleteincart", method = RequestMethod.GET)
    public String deleteInCart(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        int id_product = Integer.parseInt((String) request.getParameter("id"));
        Account user = (Account) session.getAttribute("user");
        Cart cart = (Cart) session.getAttribute("cart");
        Bill bill = BillDao.getBillNotPayByUser(user);
        CartDao.deleteProductCart(id_product, bill);
        cart.deleteProduct(id_product);
        session.setAttribute("cart", cart);
        return "redirect:/cart";
    }

}
