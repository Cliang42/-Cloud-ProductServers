package com.example.productservice.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.example.productservice.mapper.ProductMapper;
import com.example.productservice.po.Product;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/addProduct")
    public void addProduct(@RequestBody Product product) {
        productMapper.addProduct(product);
        log.info("-------------OK   /addProduct--------------------");
    }

    // 删除商品信息
    @DeleteMapping("/deleteProduct/{productId}")
    public void deleteProduct(@PathVariable Long productId) {
        productMapper.deleteProduct(productId);
        log.info("-------------OK   /deleteProduct/{productId}--------------------");
    }

    // 修改商品信息
    @PutMapping("/updateProduct")
    public void updateProduct(@RequestBody Product product) {
        productMapper.updateProduct(product);
        log.info("-------------OK   /updateProduct--------------------");
    }
}
