package com.crud.kotlin.first.exception

import java.lang.RuntimeException

class PaginationSizeLimitExceededException(
        override var message: String
) : RuntimeException()