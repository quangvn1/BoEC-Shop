/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quangvn.controller;

import java.io.IOException;
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
public class LogoutController {
    
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String doLogout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }
    
}
