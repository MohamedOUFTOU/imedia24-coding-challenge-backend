package de.imedia24.shop.service

import de.imedia24.shop.db.entity.ProductEntity
import de.imedia24.shop.db.repository.ProductRepository
import de.imedia24.shop.domain.product.ProductRequest
import de.imedia24.shop.domain.product.ProductResponse
import de.imedia24.shop.domain.product.ProductResponse.Companion.toProductResponse
import de.imedia24.shop.exception.ProductExistsException
import de.imedia24.shop.exception.ProductNotFoundException
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class ProductService(private val productRepository: ProductRepository) {

    fun findProductBySku(sku: String): ProductResponse? {
        val productEntity = productRepository.findBySku(sku)
        return productEntity?.toProductResponse() ?: throw ProductNotFoundException(message = "Product with sku = $sku Not Found in Database")
    }

    fun findProductsBySkus(skus: String): List<ProductResponse>? {
        if (skus.isEmpty()) return null
        val skuList = skus.split(',')
        return productRepository.findBySkus(skuList)?.map { productEntity -> productEntity.toProductResponse()  }
    }

    fun save(productRequest: ProductRequest): ProductResponse? {
        return if (!productRepository.existsById(productRequest.sku)){
            productRepository.save(productRequest.toProductEntity()).toProductResponse()
        } else {
            throw ProductExistsException(message = "Product with ${productRequest.sku} Already exists in Db !!!!")
        }
    }

    fun update(productRequest: ProductRequest, sku: String): ProductResponse?{
        val productEntity = productRepository.findBySku(sku)
        if (productEntity != null){
            val  updatedProductEntity = ProductEntity(
                sku = productEntity.sku,
                name = if (productRequest.name == "empty") productEntity.name else productRequest.name,
                description = if (productRequest.description == "empty") productEntity.description else productRequest.description,
                price = if (productRequest.price == BigDecimal(-1)) productEntity.price else productRequest.price,
                stockEntity = productEntity.stockEntity,
                createdAt = productEntity.createdAt
            )
            return productRepository.save(updatedProductEntity).toProductResponse()
        }
        throw ProductNotFoundException(message = "Product with sku = $sku Not Found in Database")
    }
}
