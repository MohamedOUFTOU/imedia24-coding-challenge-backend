package de.imedia24.shop.exception.handler.model

import java.time.ZonedDateTime
import org.springframework.http.HttpStatus

data class ErrorResponse(val status:HttpStatus
                         , val message:String
                         , val timestamp: ZonedDateTime = ZonedDateTime.now()) {
}