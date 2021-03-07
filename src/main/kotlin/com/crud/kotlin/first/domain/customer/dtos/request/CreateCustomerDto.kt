package com.crud.kotlin.first.domain.customer.dtos.request

import java.time.LocalDate

class CreateCustomerDto(
    var name: String = "",
    var birthDate: LocalDate = LocalDate.now(),
    var cpf: String = "",
    var email: String = "",
    var phone: String = "",
    var address: String = "",
) {
}