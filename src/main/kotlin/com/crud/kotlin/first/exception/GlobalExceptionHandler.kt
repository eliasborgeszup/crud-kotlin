package com.crud.kotlin.first.exception

import com.crud.kotlin.first.domain.customer.dtos.response.ResponseExceptionDto
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus.*
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.lang.Exception

@RestControllerAdvice
class GlobalExceptionHandler {
    private val log: Logger = LoggerFactory.getLogger(GlobalExceptionHandler::class.java)

    @ResponseStatus(UNPROCESSABLE_ENTITY)
    @ExceptionHandler(DocumentAlreadyExistsException::class)
    fun handleIllegalArgumentException(exception: DocumentAlreadyExistsException): ResponseExceptionDto {
        log.info(exception.message)
        return ResponseExceptionDto("Documento existente.")
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(NotFoundException::class)
    fun handleIllegalArgumentException(exception: NotFoundException): ResponseExceptionDto {
        log.info(exception.message)
        return ResponseExceptionDto("Documento não encontrado.")
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(PaginationSizeLimitExceededException::class)
    fun handleIllegalArgumentException(exception: PaginationSizeLimitExceededException): ResponseExceptionDto {
        log.info(exception.message)
        return ResponseExceptionDto("Quantidade de paginas maior que o permitido.")
    }

    @ResponseStatus(INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception::class)
    fun handleIllegalArgumentException(exception: Exception): ResponseExceptionDto {
        log.info(exception.message)
        return ResponseExceptionDto("Erro interno no servidor, contate o administrador do sistema. " + exception.message)
    }
}