/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quangvn.filter;

import com.quangvn.models.Product;
import java.util.List;

/**
 *
 * @author quangvn
 */
public class MediumClothesFilter implements FilterProduct {

    private final FilterProduct mediumPriceProductFilter;

    private final FilterProduct clothesProductFilter;

    public MediumClothesFilter(FilterProduct mediumPriceProductFilter, FilterProduct clothesProductFilter) {
        this.mediumPriceProductFilter = mediumPriceProductFilter;
        this.clothesProductFilter = clothesProductFilter;
    }

    @Override
    public List<Product> filterProduct(List<Product> listProduct) {
        List<Product> list = mediumPriceProductFilter.filterProduct(listProduct);
        return clothesProductFilter.filterProduct(list);
    }

}
