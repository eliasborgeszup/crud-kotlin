package com.crud.kotlin.first.domain.customer.dtos.response

import com.crud.kotlin.first.domain.customer.Customer
import java.time.LocalDate

class CustomerDto(
    var id: String = "",
    var name: String = "",
    var birthDate: LocalDate = LocalDate.now(),
    var cpf: String = "",
    var email: String = "",
    var phone: String = "",
    var address: String = ""
)  {
    infix fun fromCustomer(customer: Customer): CustomerDto{
        return CustomerDto(
            customer.id,
            customer.name,
            customer.birthDate,
            customer.cpf,
            customer.email,
            customer.phone,
            customer.address
        )
    }

}