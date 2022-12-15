package de.imedia24.shop

import de.imedia24.shop.db.entity.ProductEntity
import de.imedia24.shop.db.entity.StockEntity
import de.imedia24.shop.db.repository.ProductRepository
import de.imedia24.shop.db.repository.StockRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.math.BigDecimal
import java.math.BigInteger
import java.time.ZonedDateTime

@SpringBootApplication
class ShopApplication{
	@Bean
	fun init(productRepository: ProductRepository) = CommandLineRunner {

		productRepository.save(
			ProductEntity(
				sku = "123",
				name = "Lenovo Laptop T15",
				description = null,
				price = BigDecimal(20000),
				createdAt = ZonedDateTime.now(),
				updatedAt = ZonedDateTime.now(),
				stockEntity = StockEntity(
					quantity = BigInteger.valueOf(200)
				)
			)
		)

		productRepository.save(
			ProductEntity(
				sku = "234",
				name = "Apple MacBook pro",
				description = null,
				price = BigDecimal(40000),
				createdAt = ZonedDateTime.now(),
				updatedAt = ZonedDateTime.now(),
				stockEntity = StockEntity(
					quantity = BigInteger.valueOf(220)
				)
			)
		)

		productRepository.save(
			ProductEntity(
				sku = "456",
				name = "Hp G5 Notebook",
				description = null,
				price = BigDecimal(25000),
				createdAt = ZonedDateTime.now(),
				updatedAt = ZonedDateTime.now(),
				stockEntity = StockEntity(
					quantity = BigInteger.valueOf(298)
				)
			)
		)

		productRepository.save(
			ProductEntity(
				sku = "678",
				name = "Dell Xps",
				description = null,
				price = BigDecimal(28000),
				createdAt = ZonedDateTime.now(),
				updatedAt = ZonedDateTime.now(),
				stockEntity = StockEntity(
					quantity = BigInteger.valueOf(314)
				)
			)
		)
	}
}

fun main(args: Array<String>) {
	runApplication<ShopApplication>(*args)
}


