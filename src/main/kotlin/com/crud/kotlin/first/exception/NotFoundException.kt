package com.crud.kotlin.first.exception

import java.lang.RuntimeException

class NotFoundException (
    override var message: String = ""
): RuntimeException(){}