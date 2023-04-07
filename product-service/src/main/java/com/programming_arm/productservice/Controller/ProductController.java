package com.programming_arm.productservice.Controller;

import com.programming_arm.productservice.Dto.Requset.RequestProductDto;
import com.programming_arm.productservice.Dto.Response.ResponseProductDto;
import com.programming_arm.productservice.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    final private ProductService productService;

    @PostMapping("/createProduct")
    public ResponseEntity<RequestProductDto>  createProduct(@RequestBody RequestProductDto productDto){
        return new ResponseEntity<>(productService.create(productDto), HttpStatus.OK);
    }

    @GetMapping(value = "/getAllProduct")
    public ResponseEntity<List<ResponseProductDto>> getAllPProduct(){
        return new ResponseEntity<>(productService.getAllPProduct(),HttpStatus.OK);
    }











}
