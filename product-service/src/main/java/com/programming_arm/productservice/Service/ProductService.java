package com.programming_arm.productservice.Service;

import com.programming_arm.productservice.Dto.Requset.RequestProductDto;
import com.programming_arm.productservice.Dto.Response.ResponseProductDto;

import java.util.List;

public interface ProductService {
    RequestProductDto create(RequestProductDto productDto);

    List<ResponseProductDto> getAllPProduct();
}
