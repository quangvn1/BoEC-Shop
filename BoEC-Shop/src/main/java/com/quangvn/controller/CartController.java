/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quangvn.controller;

import com.quangvn.model.Account;
import com.quangvn.model.NullAccount;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author VAN
 */
@Controller
@RequestMapping(value = "/cart")
public class CartController {
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView doCart() {
        return new ModelAndView("cart", "acc", new NullAccount());
    }
    
}
