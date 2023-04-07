package com.programming_arm.productservice.Dto.Mapper;

import com.programming_arm.productservice.Dto.Requset.RequestProductDto;
import com.programming_arm.productservice.Dto.Response.ResponseProductDto;
import com.programming_arm.productservice.Model.Product;

public class ProductMapper {
    private ProductMapper(){

    }
    public static ResponseProductDto mapTpResponseProductDto(Product product){
        return new ResponseProductDto(product.getId(), product.getName(), product.getDescription(), product.getPrice());
    }
    public static RequestProductDto mapTpRequsetProductDto(Product product){
        return new RequestProductDto( product.getName(), product.getDescription(), product.getPrice());
    }
}
