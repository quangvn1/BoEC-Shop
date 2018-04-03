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
public class MediumElectronicFilter implements FilterProduct {

    private final FilterProduct mediumPriceProductFilter;

    private final FilterProduct electronicProductFilter;

    public MediumElectronicFilter(FilterProduct mediumPriceProductFilter, FilterProduct electronicProductFilter) {
        this.mediumPriceProductFilter = mediumPriceProductFilter;
        this.electronicProductFilter = electronicProductFilter;
    }

    @Override
    public List<Product> filterProduct(List<Product> listProduct) {
        List<Product> list = mediumPriceProductFilter.filterProduct(listProduct);
        return electronicProductFilter.filterProduct(list);
    }

}
