package de.imedia24.shop.domain.stock

import java.math.BigInteger

data class StockRequest(
    val quantity: BigInteger = BigInteger.ZERO
) {
}