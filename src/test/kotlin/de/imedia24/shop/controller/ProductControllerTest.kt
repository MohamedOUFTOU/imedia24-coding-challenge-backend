package de.imedia24.shop.controller

import de.imedia24.shop.domain.product.ProductResponse
import de.imedia24.shop.service.ProductService
import io.mockk.every
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.http.MediaType
import java.math.BigDecimal
import java.math.BigInteger

@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest (@Autowired val mockMvc: MockMvc) {

    @MockBean
    lateinit var productService: ProductService

    @BeforeEach
    fun setUp() {
    }

    @AfterEach
    fun tearDown() {
    }


    @Test
    fun canFindProductsBySkus() {
        // Given
        val skus  = "123,234"
        val product1 = ProductResponse(
            sku = "123",
            name = "Product 1 Test name",
            description = "Product 1 Test description",
            price = BigDecimal(1000),
            quantity = BigInteger.valueOf(2000)
        )

        val product2 = ProductResponse(
            sku = "234",
            name = "Product 2 Test name",
            description = "Product 2 Test description",
            price = BigDecimal(1200),
            quantity = BigInteger.valueOf(2100)
        )

        every { productService.findProductsBySkus(skus) } returns listOf(product1, product2);
        // When
        mockMvc.get("/products?skus=$skus")
            .andExpect {  status { isOk() }
                content { contentType(MediaType.APPLICATION_JSON) } }
    }


    @Test
    fun updateProduct() {
    }
}