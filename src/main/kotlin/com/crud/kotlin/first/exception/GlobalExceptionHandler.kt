package com.crud.kotlin.first.exception

import com.crud.kotlin.first.domain.customer.dtos.response.ErrorDto
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus.*
import org.springframework.validation.ObjectError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.lang.Exception

@RestControllerAdvice
class GlobalExceptionHandler {
    private val log: Logger = LoggerFactory.getLogger(GlobalExceptionHandler::class.java)

    @ResponseStatus(UNPROCESSABLE_ENTITY)
    @ExceptionHandler(DocumentAlreadyExistsException::class)
    fun handleIllegalArgumentException(exception: DocumentAlreadyExistsException): ErrorDto {
        log.info(exception.message)
        return ErrorDto("Documento existente.")
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(NotFoundException::class)
    fun handleIllegalArgumentException(exception: NotFoundException): ErrorDto {
        log.info(exception.message)
        return ErrorDto("Documento não encontrado.")
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(PaginationSizeLimitExceededException::class)
    fun handleIllegalArgumentException(exception: PaginationSizeLimitExceededException): ErrorDto {
        log.info(exception.message)
        return ErrorDto("Quantidade de paginas maior que o permitido.")
    }

/*    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleIllegalArgumentException(exception: MethodArgumentNotValidException): List<ErrorDto>{
        var errors: MutableList<ErrorDto> = mutableListOf()

        for (error: ObjectError in exception.bindingResult.allErrors){
            var messageDisplayed: StringBuilder = StringBuilder()

            messageDisplayed.append(error.defaultMessage)
            errors.add(error(messageDisplayed.toString()))
        }
        return errors
    }*/

    @ResponseStatus(INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception::class)
    fun handleIllegalArgumentException(exception: Exception): ErrorDto {
        log.info(exception.message)
        return ErrorDto("Erro interno no servidor, contate o administrador do sistema. " + exception.message)
    }
}