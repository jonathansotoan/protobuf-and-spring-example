package com.caletre.shop.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.caletre.shop.model.ProductOuterClass.Product;
import com.caletre.shop.model.ProductOuterClass.ProductList;

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
    
    @RequestMapping(method = RequestMethod.POST)
    public ProductList saveProduct(@RequestBody Product product) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("C:/Users/jsotom/shop/products.bin", true);
        FileInputStream fileInputStream = new FileInputStream("C:/Users/jsotom/shop/products.bin");
        ProductList deserializedProducts;
        
        try {            
            deserializedProducts = ProductList.parseFrom(fileInputStream);
            ProductList.Builder productListBuilder =
                    deserializedProducts == null
                        ? ProductList.newBuilder()
                        : ProductList.newBuilder(deserializedProducts);
            productListBuilder.addProducts(product);
            deserializedProducts = productListBuilder.build(); 
            deserializedProducts.writeTo(fileOutputStream);
        } finally {
            fileOutputStream.close();
            fileInputStream.close();
        }
        
        return deserializedProducts;
    }
}
