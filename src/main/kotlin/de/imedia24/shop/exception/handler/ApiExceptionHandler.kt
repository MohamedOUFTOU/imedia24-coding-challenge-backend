package de.imedia24.shop.exception.handler

import de.imedia24.shop.exception.ProductExistsException
import de.imedia24.shop.exception.ProductNotFoundException
import de.imedia24.shop.exception.handler.model.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ApiExceptionHandler {

    @ExceptionHandler(ProductNotFoundException::class)
    fun handleProductNotFoundException(exception: ProductNotFoundException): ResponseEntity<ErrorResponse> {
        return ResponseEntity(
            ErrorResponse(
                status = HttpStatus.NOT_FOUND,
                message = exception.message ?: ""
            ), HttpStatus.NOT_FOUND
        )
    }

    @ExceptionHandler(ProductExistsException::class)
    fun handleProductExistsException(exception: ProductExistsException): ResponseEntity<ErrorResponse> {
        return ResponseEntity(
            ErrorResponse(
                status = HttpStatus.BAD_REQUEST,
                message = exception.message ?: ""
            ), HttpStatus.BAD_REQUEST
        )
    }
}