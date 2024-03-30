package com.example.productservice.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.example.productservice.mapper.ProductMapper;
import com.example.productservice.po.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@AllArgsConstructor
@RestController
@Slf4j
public class ProductController {
    private final ProductMapper productMapper;
    /**
     * 根据商品 id 查询商品
     */
    @GetMapping("/findByProductId/{productId}")
    public Product findByProductId(@PathVariable Long productId)
    {
        Product product = productMapper.findByProductId(productId);
        //Thread.sleep(2000);
        log.info("-------------OK   /findByProductId/{productId}--------------------");
        return product;
    }
    /**
     * 查询所有商品
     */
    @GetMapping("/queryAllProduct")
    public List<Product> findByProductId() {
        List<Product> productList = productMapper.queryAllProduct();
        log.info("-------------OK   queryAllProduct--------------------");
        return productList;
    }

    @GetMapping("/addProduct/{product}")
    public void addProduct(@PathVariable Product product){
        productMapper.addProduct(product);
        log.info("-------------OK   addProduct--------------------");
    }
}
