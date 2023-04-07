package com.programming_arm.productservice.Service.ServiceImpl;

import com.programming_arm.productservice.Dto.ConverterDto.ProductDtoConvert;
import com.programming_arm.productservice.Dto.Requset.RequestProductDto;
import com.programming_arm.productservice.Dto.Response.ResponseProductDto;
import com.programming_arm.productservice.Model.Product;
import com.programming_arm.productservice.Repository.ProductRepository;
import com.programming_arm.productservice.Service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl  implements ProductService {

    final private ProductDtoConvert productDtoConvert;
    final private ProductRepository productRepository;
    @Override
    public RequestProductDto create(RequestProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        productRepository.save(product);
        log.info("Product : {} is Save",product.getId());
        return productDtoConvert.convert(product);
    }

    @Override
    public List<ResponseProductDto> getAllPProduct() {
        return productDtoConvert.convert(productRepository.findAll());
    }
}
