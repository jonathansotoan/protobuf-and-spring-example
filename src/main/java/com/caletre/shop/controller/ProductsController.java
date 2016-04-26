package com.caletre.shop.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.caletre.shop.model.ProductOuterClass.Product;

@RestController
public class ProductsController {
    
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public byte[] getAll(@RequestParam(value = "name", defaultValue = "Cookies") String productName) {
        Product product =
            Product.newBuilder()
                .setId(20)
                .setName(productName)
                .build();
        
        return product.toByteArray();
    }
}
