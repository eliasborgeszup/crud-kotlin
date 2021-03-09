package com.crud.kotlin.first.domain.customer.config

import com.crud.kotlin.first.exception.PaginationSizeLimitExceededException
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class PageSizeValidator {

    companion object {
        val log: Logger = LoggerFactory.getLogger(PageSizeValidator::class.java)

        fun validate(
                nameClass: String,
                SIZE_MAX_PAGE: Int,
                size: Int) {
            if (size > SIZE_MAX_PAGE){
                log.error("Pagination size limit exceeded = $size , maximum allowed = $SIZE_MAX_PAGE")

                throw PaginationSizeLimitExceededException(nameClass + ":findAll")
            }
        }
    }
}