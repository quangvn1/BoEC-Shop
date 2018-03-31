/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quangvn.builder;

import com.quangvn.models.Product;

/**
 *
 * @author quangvn
 */
public abstract class ProductBuilder {

    public abstract ProductBuilder setKeyStatus(String keyStatus);

    public abstract Product build();

    public static class ProductKeyStatusBuilder extends ProductBuilder {

        private Product product;

        public ProductKeyStatusBuilder(int id, String name, String image, int price, int oldPrice) {
            product = new Product();
            product.setId(id);
            product.setName(name);
            product.setImage(image);
            product.setPrice(price);
            product.setOldPrice(oldPrice);
        }

        @Override
        public ProductBuilder setKeyStatus(String keyStatus) {
            product.setKeyStatus(keyStatus);
            return this;
        }

        @Override
        public Product build() {
            return product;
        }

    }
}
