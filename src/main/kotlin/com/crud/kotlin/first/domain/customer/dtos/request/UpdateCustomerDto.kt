package com.crud.kotlin.first.domain.customer.dtos.request

import java.time.LocalDate

class UpdateCustomerDto (
    var name: String = "",
    var birthDate: LocalDate = LocalDate.now(),
    var email: String = "",
    var phone: String = "",
    var address: String = ""
        ){

}
