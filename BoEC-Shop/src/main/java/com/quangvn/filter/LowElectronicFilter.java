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
public class LowElectronicFilter implements FilterProduct{
    private final FilterProduct lowPriceProductFilter;

    private final FilterProduct electronicProductFilter;

    public LowElectronicFilter(FilterProduct lowPriceProductFilter, FilterProduct electronicProductFilter) {
        this.lowPriceProductFilter = lowPriceProductFilter;
        this.electronicProductFilter = electronicProductFilter;
    }
    
    @Override
    public List<Product> filterProduct(List<Product> listProduct) {
        List<Product> list = lowPriceProductFilter.filterProduct(listProduct);
        return electronicProductFilter.filterProduct(list);
    }
    
    
}
