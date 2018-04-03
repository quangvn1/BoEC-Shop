/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quangvn.controller;

import com.quangvn.dao.ProductDao;
import com.quangvn.filter.BookProductFilter;
import com.quangvn.filter.ClothesProductFilter;
import com.quangvn.filter.ElectronicProductFilter;
import com.quangvn.filter.FilterProduct;
import com.quangvn.filter.LowPriceProductFilter;
import com.quangvn.filter.MediumPriceProductFilter;
import com.quangvn.models.AbstractProduct;
import com.quangvn.models.Product;
import com.quangvn.service.ProductService;
import java.util.ArrayList;
import java.util.List;
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
public class ProductController {
    
    @RequestMapping(value = "/productdetail", method = RequestMethod.GET)
    public String showProductDetail(Model model, HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt((String) request.getParameter("id"));
        Product product = ProductDao.getProductById(id);
        model.addAttribute("product", product);
        return "product/productdetail";
    }
    
    @RequestMapping(value = "/listproduct", method = RequestMethod.GET)
    public String getProduct(Model model) {
        List<Product> listSpecial = ProductService.getInstance().getProductByKeyStatus("dacbiet");
        List<Product> listProduct = ProductService.getInstance().getProduct();
        model.addAttribute("listSpecial", listSpecial);
        model.addAttribute("listProduct", listProduct);
        return "product/listproduct";
    }

    @RequestMapping(value = "/filterproduct", method = RequestMethod.POST)
    public String filterProduct(Model model, String typeProduct, String price) {
        List<Product> list = ProductService.getInstance().getProduct();
        List<Product> listSpecial = ProductService.getInstance().getProductByKeyStatus("dacbiet");
        List<Product> listTemp;
        List<Product> listProduct = new ArrayList<>();
        if (typeProduct == null) {
            typeProduct = "Tatca";
        }
        if (price == null) {
            price = "Tatca";
        }
        switch (typeProduct) {
            case "Book":
                FilterProduct bookFilter = new BookProductFilter();
                listTemp = bookFilter.filterProduct(list);
                switch (price) {
                    case "low":
                        FilterProduct lowFilter = new LowPriceProductFilter();
                        listProduct = lowFilter.filterProduct(listTemp);
                        break;
                    case "medium":
                        FilterProduct mediumFilter = new MediumPriceProductFilter();
                        listProduct = mediumFilter.filterProduct(listTemp);
                        break;
                    case "Tatca":
                        listProduct = listTemp;
                        break;
                }
                break;
            case "Electronic":
                FilterProduct electronicFilter = new ElectronicProductFilter();
                listTemp = electronicFilter.filterProduct(list);
                switch (price) {
                    case "low":
                        FilterProduct lowFilter = new LowPriceProductFilter();
                        listProduct = lowFilter.filterProduct(listTemp);
                        break;
                    case "medium":
                        FilterProduct mediumFilter = new MediumPriceProductFilter();
                        listProduct = mediumFilter.filterProduct(listTemp);
                        break;
                    case "Tatca":
                        listProduct = listTemp;
                        break;
                }
                break;
            case "Clothes":
                FilterProduct clothesFilter = new ClothesProductFilter();
                listTemp = clothesFilter.filterProduct(list);
                switch (price) {
                    case "low":
                        FilterProduct lowFilter = new LowPriceProductFilter();
                        listProduct = lowFilter.filterProduct(listTemp);
                        break;
                    case "medium":
                        FilterProduct mediumFilter = new MediumPriceProductFilter();
                        listProduct = mediumFilter.filterProduct(listTemp);
                        break;
                    case "Tatca":
                        listProduct = listTemp;
                        break;
                }
                break;
            case "Tatca":
                switch (price) {
                    case "low":
                        FilterProduct lowFilter = new LowPriceProductFilter();
                        listProduct = lowFilter.filterProduct(list);
                        break;
                    case "medium":
                        FilterProduct mediumFilter = new MediumPriceProductFilter();
                        listProduct = mediumFilter.filterProduct(list);
                        break;
                    case "Tatca":
                        listProduct = list;
                        break;
                }
                break;
        }
        model.addAttribute("listSpecial", listSpecial);
        model.addAttribute("listProduct", listProduct);
        model.addAttribute("typeProduct", typeProduct);
        model.addAttribute("price", price);
        return "product/listproduct";
    }

    @RequestMapping(value = "/searchproduct", method = RequestMethod.POST)
    public String searchProduct(Model model, String key) {
        List<AbstractProduct> listProduct = ProductService.getInstance().getProductByName(key);
        List<Product> listSpecial = ProductService.getInstance().getProductByKeyStatus("dacbiet");
        model.addAttribute("listSpecial", listSpecial);
        model.addAttribute("listProduct", listProduct);
        return "product/listproduct";
    }
}
