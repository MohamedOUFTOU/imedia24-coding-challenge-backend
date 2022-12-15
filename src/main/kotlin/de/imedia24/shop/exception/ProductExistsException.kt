package de.imedia24.shop.exception

class ProductExistsException : RuntimeException {
    constructor(message: String): super(message) {}
    constructor(message: String, cause: Throwable) : super(message, cause) { }
}