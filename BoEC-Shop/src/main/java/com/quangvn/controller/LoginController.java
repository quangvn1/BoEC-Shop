/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quangvn.controller;

import com.quangvn.dao.AccountDAO;
import com.quangvn.model.Account;
import com.quangvn.model.NullAccount;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author VAN
 */
@Controller
public class LoginController {
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView doLogin() {
        return new ModelAndView("index", "acc", new NullAccount());
    }
    
    @RequestMapping( value="/checkLogin", method = RequestMethod.POST)
    public void checkUser(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Account entity = AccountDAO.checkAccount(username, password);
        if ( !entity.isNull() ) {
            session.setAttribute("user", entity);
            String[] _split_name = entity.getFullname().split(" ");
            session.setAttribute("fullname", _split_name[_split_name.length-1]);
        }
        response.sendRedirect("/BoEC-Shop/");
    }
}
