/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quangvn.controller;

import com.quangvn.model.Account;
import com.quangvn.model.NullAccount;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.quangvn.models.Product;
import com.quangvn.service.ProductService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author quangvn
 */
@Controller
@RequestMapping(value = "/home")
public class IndexController extends HttpServlet {


 
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        List<Product> listHot = ProductService.getProductByKeyStatus("hot");
        List<Product> listEndow = ProductService.getProductByKeyStatus("uudai");
        List<Product> listSpecial = ProductService.getProductByKeyStatus("dacbiet");
        List<Product> listSaleOff = ProductService.getProductByKeyStatus("khuyenmai");
        List<Product> listNew = ProductService.getProductByKeyStatus("moi");
        model.addAttribute("listHot", listHot);
        model.addAttribute("listEndow", listEndow);
        model.addAttribute("listSpecial", listSpecial);
        model.addAttribute("listSaleOff", listSaleOff);
        model.addAttribute("listNew", listNew);
        return "index";
    }

}
