package de.imedia24.shop.domain.product

import de.imedia24.shop.db.entity.ProductEntity
import de.imedia24.shop.db.entity.StockEntity
import de.imedia24.shop.domain.stock.StockRequest
import io.swagger.v3.oas.annotations.media.Schema
import java.math.BigDecimal

@Schema(description = "Model for Product.")
data class ProductRequest(
    @field:Schema(
        description = "Unique Identifier for the product",
        example = "152",
        type = "String"
    )
    val sku: String = "empty",
    @field:Schema(
        description = "Label of the product",
        example = "Mac Laptop",
        type = "String"
    )
    val name: String = "empty",
    @field:Schema(
        description = "Description for the product",
        example = "",
        type = "String"
    )
    val description: String = "empty",
    @field:Schema(
        description = "price of the product",
        example = "4000",
        type = "BigDecimal"
    )
    val price: BigDecimal = BigDecimal(-1),
    @field:Schema(
        description = "Stock Information for the product",
        type = "StockRequest"
    )
    val stock: StockRequest?
) {
    fun toProductEntity() = ProductEntity(
        sku = sku,
        name = name,
        description = description,
        price = price,
        stockEntity = stock?.quantity?.let {
            StockEntity(
            )
        }
    )

    override fun toString(): String {
        return "ProductRequest(sku='$sku', name='$name', description='$description', price=$price)"
    }
}