package com.crud.kotlin.first.domain.customer.dtos.response

import com.crud.kotlin.first.domain.customer.Customer
import java.time.LocalDate

data class CustomerDto(
        val id: String,
        val name: String,
        val birthDate: LocalDate,
        val cpf: String,
        val email: String,
        val phone: String,
        val address: String
) {
    companion object {
        fun fromCustomer(customer: Customer): CustomerDto {
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
}