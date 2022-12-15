package de.imedia24.shop.exception

class ProductNotFoundException : RuntimeException {
    constructor(message: String): super(message) { }
    constructor(message: String, cause: Throwable) : super(message, cause) { }
}