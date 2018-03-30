/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quangvn.controller;

import com.quangvn.models.Product;
import com.quangvn.service.ProductService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author quangvn
 */
@Controller
public class IndexController {

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
