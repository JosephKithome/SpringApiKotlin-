package com.joseph.jmall.exceptions

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import javax.servlet.http.HttpServletRequest


@ControllerAdvice
class JmallErrorHandler {

    @ExceptionHandler(JmallNotFoundException::class) // 2
    fun handleProductNotFoundException(
        servletRequest: HttpServletRequest,
        exception: Exception
    ): ResponseEntity<String> {
        return ResponseEntity("NFT not found", HttpStatus.NOT_FOUND) // 3
    }
}