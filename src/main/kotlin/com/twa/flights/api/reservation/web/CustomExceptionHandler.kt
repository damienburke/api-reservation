package com.twa.flights.api.reservation.web

import org.springframework.http.HttpStatus
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class CustomExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleInvalidArgument(exception: MethodArgumentNotValidException): Map<String, String> {

        println("handle $exception")
        println("handling ${exception.bindingResult.fieldErrors}")

        val errorMap = mutableMapOf<String, String>()

        exception.bindingResult.fieldErrors.forEach { error ->
            errorMap.put(error.field, error.defaultMessage!!)
        }
        println("errorMap $errorMap")
        errorMap.forEach { "error: $it" }
        return errorMap
    }

}