package de.imedia24.shop.controller

import de.imedia24.shop.domain.product.ProductRequest
import de.imedia24.shop.domain.product.ProductResponse
import de.imedia24.shop.service.ProductService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/products")
class ProductController(private val productService: ProductService) {

    private val logger = LoggerFactory.getLogger(ProductController::class.java)!!

    @Operation(summary = "Get a product by sku")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Successful Operation"),
            ApiResponse(responseCode = "404", description = "Such a product does not exist"),
        ]
    )
    @GetMapping("/{sku}", produces = ["application/json;charset=utf-8"])
    fun findProductsBySku(
        @PathVariable("sku") sku: String
    ): ProductResponse? {
        logger.info("Request for /products/$sku")

        return productService.findProductBySku(sku)

    }

    @Operation(summary = "Get a list of products by skus")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Successful Operation"),
            ApiResponse(responseCode = "204", description = "Empty list"),
        ]
    )
    @GetMapping("", produces = ["application/json;charset=utf-8"])
    fun findProductsBySkus(
        @RequestParam("skus") skus: String
    ): List<ProductResponse>? {
        logger.info("Request for /products?skus=$skus")

       return productService.findProductsBySkus(skus)
    }

    @Operation(summary = "Add a product")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Successful Operation"),
            ApiResponse(responseCode = "404", description = "The product didn't get saved correctly"),
        ]
    )
    @PostMapping("", consumes = ["application/json;charset=utf-8"])
    fun addProduct(
        @RequestBody productRequest: ProductRequest
    ): ProductResponse? {
        logger.info("Request for saving $productRequest")

        return productService.save(productRequest)
    }

    @Operation(summary = "Update a product")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Successful Operation"),
            ApiResponse(responseCode = "404", description = "The product didn't get updated correctly"),
        ]
    )
    @PatchMapping("/{sku}", consumes = ["application/json;charset=utf-8"])
    fun updateProduct(
        @RequestBody productRequest: ProductRequest,
        @PathVariable("sku") sku: String
    ): ProductResponse? {
        logger.info("Request for updating $productRequest")

        return productService.update(productRequest, sku)
    }
}
