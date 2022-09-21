package com.cadb.craftsman.msscbrewery.exceptions

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import javax.validation.ConstraintViolationException

@ControllerAdvice
class MVCExceptionHandler {
    @ExceptionHandler(ConstraintViolationException::class)
    fun validationErrorHandler(e: ConstraintViolationException): ResponseEntity<List<String>> {
        var errors = ArrayList<String>(e.constraintViolations.size)

        e.constraintViolations.forEach {
            errors.add(it.propertyPath.toString() + ":" + it.message)
        }

        return ResponseEntity(errors, HttpStatus.BAD_REQUEST)
    }
}