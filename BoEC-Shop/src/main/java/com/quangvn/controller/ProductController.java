/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quangvn.controller;

import com.quangvn.dao.ProductDao;
import com.quangvn.models.Product;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author quangvn
 */
@Controller
@RequestMapping(value = "/productdetail")
public class ProductController {
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String showProductDetail(Model model, HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt((String) request.getParameter("id"));
        Product product = ProductDao.getProductById(id);
        model.addAttribute("product", product);
        return "productdetail";
    }
    
}
