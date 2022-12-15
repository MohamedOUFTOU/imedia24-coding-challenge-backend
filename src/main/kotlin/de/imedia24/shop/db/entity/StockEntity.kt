package de.imedia24.shop.db.entity

import org.hibernate.annotations.UpdateTimestamp
import java.math.BigInteger
import java.time.ZonedDateTime
import javax.persistence.*

@Entity
@Table(name = "products_stock")
data class StockEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stock_id", nullable = false)
    val stockId: Long = -1,

    @Column(name = "quantity", nullable = false)
    val quantity: BigInteger = BigInteger.ZERO,

    @UpdateTimestamp
    @Column(name = "created_at", nullable = false)
    val createdAt: ZonedDateTime = ZonedDateTime.now(),

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    val updatedAt: ZonedDateTime = ZonedDateTime.now()
){
}