package com.crud.kotlin.first.domain.customer.dtos.response

import com.crud.kotlin.first.domain.customer.Customer

class CustomerDto(
    var id: String = "",
    var name: String = "",
    var birthDate: String = "",
    var cpf: String = "",
    var email: String = "",
    var phone: String = "",
    var address: String = "",
)  {
    fun fromCustomer(customer: Customer): CustomerDto{
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