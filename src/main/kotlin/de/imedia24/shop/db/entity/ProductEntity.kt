package de.imedia24.shop.db.entity

import com.fasterxml.jackson.annotation.JsonProperty
import org.hibernate.annotations.UpdateTimestamp
import java.math.BigDecimal
import java.time.ZonedDateTime
import javax.persistence.*

@Entity
@Table(name = "products")
data class ProductEntity(
    @Id
    @Column(name = "sku", nullable = false, updatable = false)
    val sku: String = "",

    @Column(name = "name", nullable = false)
    val name: String = "",

    @Column(name = "description")
    val description: String? = null,

    @Column(name = "price", nullable = false)
    val price: BigDecimal = BigDecimal(0),

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "stock_id", referencedColumnName = "stock_id")
    val stockEntity: StockEntity? = null,

    @UpdateTimestamp
    @Column(name = "created_at", nullable = false)
    val createdAt: ZonedDateTime = ZonedDateTime.now(),

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    val updatedAt: ZonedDateTime = ZonedDateTime.now()
) {
}
