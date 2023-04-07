package com.programming_arm.productservice.Dto.ConverterDto;

import com.programming_arm.productservice.Dto.Mapper.ProductMapper;
import com.programming_arm.productservice.Dto.Requset.RequestProductDto;
import com.programming_arm.productservice.Dto.Response.ResponseProductDto;
import com.programming_arm.productservice.Model.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductDtoConvert {
    public RequestProductDto convert(Product from) {
        return ProductMapper.mapTpRequsetProductDto(from);
    }

    public List<ResponseProductDto> convert(List<Product> from) {
        return from.stream().map(ProductMapper::mapTpResponseProductDto).collect(Collectors.toList());
    }
}
