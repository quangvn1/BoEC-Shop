/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quangvn.controller;

import static com.quangvn.controller.RegistrationController.arrayError;
import com.quangvn.dao.AccountDao;
import com.quangvn.model.Account;
import com.quangvn.model.CustomerAccount;
import com.tungns.chain.AbstractChecking;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author nguye
 */
@Controller
public class PaymentController {
    
    @RequestMapping(value = "/pay", method = RequestMethod.GET)
    public String showPage(HttpSession session, Model model){
        Account user = (Account) session.getAttribute("user");
        model.addAttribute("user", user);
        return "payment/infopay";
    }
    
    @RequestMapping(value = "/pay", method = RequestMethod.POST)
    public String pay(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws UnsupportedEncodingException, IOException {
        request.setCharacterEncoding("UTF-8");
        String fullName = request.getParameter("fullName");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String tel = request.getParameter("tel");
        String gender = request.getParameter("time");
        if (fullName != null && email != null && tel != null && gender != null && address != null
                && !"".equals(fullName) && !"".equals(email) && !"".equals(tel) && !"".equals(gender) && !"".equals(address)) {
            Account user = new CustomerAccount();
            user.setEmail(email);
            user.setPhone(tel);
            user.setFullname(fullName);
            user.setGender(gender);
            user.setAddress(address);           
                request.setAttribute("msg", "Đăng kí tài khoản mới thành công");
                session.setAttribute("user", user);     
        } else {
            String warn = "Quý khách chưa nhập đủ thông tin đăng kí";
            request.setAttribute("warn", warn);
        }
        return "payment/result";
    }
}
