package com.caletre.shop.controller;

import java.util.Base64;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.caletre.shop.model.ProductOuterClass.Product;

@RestController
@RequestMapping("/rest/api/v1/products")
public class ProductsController {
    
    @RequestMapping(value = "/{productId}/json", method = RequestMethod.GET)
    public Product getProductAsJson(
            @PathVariable int productId,
            @RequestParam(value = "name", defaultValue = "Cookies") String productName) {
        Product product =
            Product.newBuilder()
                .setId(productId)
                .setName(productName)
                .setPrice("$23456,31")
                .build();
        
        return product;
    }
    
    @RequestMapping(value = "/{productId}/protobuf", method = RequestMethod.GET)
    public String getProductAsProtobuf(
            @PathVariable int productId,
            @RequestParam(value = "name", defaultValue = "Cookies") String productName) {
        Product product =
                Product.newBuilder()
                    .setId(productId)
                    .setName(productName)
                    .setPrice("$98,53")
                    .build();
            
            String result = Base64.getEncoder().encodeToString(product.toByteArray());
            
            return result;
    }
}
