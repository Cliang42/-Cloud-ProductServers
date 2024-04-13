package com.example.productservice.mapper;

import com.example.productservice.po.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ProductMapper {
    @Select("select p.product_name as productName,p.price as price from product p where id = #{productId}")
    Product findByProductId(@Param("productId") Long productId);

    @Select("select p.id,p.product_name as productName,p.price as price from product p")
    List<Product> queryAllProduct();

    @Insert("insert into product (id, product_name, price) values (#{product.id}, #{product.productName}, #{product.price})")
    void addProduct(@Param("product") Product product);

    @Delete("delete from product where id = #{productId}")
    void deleteProduct(@Param("productId") Long productId);

    // 修改商品信息
    @Update("update product set product_name = #{product.productName}, price = #{product.price} where id = #{product.id}")
    void updateProduct(@Param("product") Product product);


}
