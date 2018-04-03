/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quangvn.controller;

import com.quangvn.dao.AccountDao;
import com.quangvn.model.Account;
import com.quangvn.model.CustomerAccount;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author VAN
 */
@Controller
public class RegistrationController {

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String showPage() {
        return "registration/registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws UnsupportedEncodingException, IOException {
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String fullName = request.getParameter("fullName");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String tel = request.getParameter("tel");
        String gender = request.getParameter("gender");
        if (username != null && password != null && fullName != null && email != null && tel != null && gender != null && address != null
                && !"".equals(username) && !"".equals(password) && !"".equals(fullName) && !"".equals(email) && !"".equals(tel) && !"".equals(gender) && !"".equals(address)) {
            Account user = new CustomerAccount();
            user.setUsername(username);
            user.setPassword(password);
            user.setEmail(email);
            user.setPhone(tel);
            user.setFullname(fullName);
            user.setGender(gender);
            user.setAddress(address);
            if (AccountDao.checkExistUser(username)) {
                request.setAttribute("msgUsername", "Tài khoản đã tồn tại");
            } else if (AccountDao.checkExistEmail(email)) {
                request.setAttribute("msgEmail", "Email đã được đăng kí");
            } else if (AccountDao.checkExistTel(tel)) {
                request.setAttribute("msgTel", "Số điện thoại đã được đăng kí");
            } else if (AccountDao.registration(user)) {
                request.setAttribute("msg", "Đăng kí tài khoản mới thành công");
                session.setAttribute("user", user);
                String[] _split_name = user.getFullname().split(" ");
                session.setAttribute("fullname", _split_name[_split_name.length - 1]);
            }
        } else {
            String warn = "Quý khách chưa nhập đủ thông tin đăng kí";
            request.setAttribute("warn", warn);
        }
        return "registration/registration";
    }

}
