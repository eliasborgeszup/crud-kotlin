package com.crud.kotlin.first.exception

import java.lang.RuntimeException

class DocumentAlreadyExistsException(
        override var message: String
) : RuntimeException()
