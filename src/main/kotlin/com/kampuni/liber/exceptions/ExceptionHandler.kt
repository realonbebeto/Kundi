package com.kampuni.liber.exceptions

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(IllegalStateException::class)
    fun handleIllegalState(exception: IllegalStateException): ResponseEntity<CustomException>{
        return ResponseEntity.badRequest().body(CustomException(errorMsg = exception.localizedMessage))
    }
}