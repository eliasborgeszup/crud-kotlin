package com.crud.kotlin.first.domain.customer.dtos.request

import org.hibernate.validator.constraints.br.CPF
import java.time.LocalDate
import javax.validation.constraints.*

class CreateCustomerDto(
        @field: NotBlank(message = "{validation.blank}")
        var name: String = "",

        @field: Past(message = "{validation.invalid.date}")
        var birthDate: LocalDate = LocalDate.now(),

        @field: CPF(message = "{validation.invalid.cpf}")
        var cpf: String = "",

        @field: Email(message = "{validation.invalid.email}")
        @field: NotBlank(message = "{validation.blank}")
        var email: String = "",

        @field: Pattern(regexp = "^[0-9]*", message = "{validation.phone}")
        @field: Size(min = 10, max = 11, message = "{validation.size}")
        var phone: String = "",

        @field: NotBlank(message = "{validation.blank}")
        var address: String = ""
) {
}