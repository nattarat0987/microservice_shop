package com.programming_arm.productservice.ContainersMogoTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.programming_arm.productservice.Dto.Requset.RequestProductDto;
import com.programming_arm.productservice.Repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
public class ProductTest {

    @Container
    static MongoDBContainer mongoDBContainer = new MongoDBContainer(DockerImageName.parse("mongo:4.4.2").asCompatibleSubstituteFor("mongodb"));

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    private ProductRepository productRepository;


    @DynamicPropertySource
    static void setProperties(DynamicPropertyRegistry dynamicPropertyRegistry) {
        dynamicPropertyRegistry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
    }

    @Test
    void shouldCreateProduct() throws Exception {
        RequestProductDto productRequest = getProductRequest();
        String productRequestasString = objectMapper.writeValueAsString(productRequest);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/product/createProduct")
                .contentType(MediaType.APPLICATION_JSON)
                .content(productRequestasString)
        ).andExpect(status().isOk());

        Assertions.assertEquals(1, productRepository.findAll().size());

    }

    private RequestProductDto getProductRequest() {
        return RequestProductDto.builder()
                .name("NATTARAT")
                .description("Test")
                .price(BigDecimal.valueOf(10000.11))
                .build();
    }


}
