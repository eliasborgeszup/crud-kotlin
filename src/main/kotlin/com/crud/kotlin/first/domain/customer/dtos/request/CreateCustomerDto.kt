package com.crud.kotlin.first.domain.customer.dtos.request

import org.hibernate.validator.constraints.br.CPF
import java.time.LocalDate
import javax.validation.constraints.*

class CreateCustomerDto(
        @NotBlank(message = "{validation.blank}")
        var name: String = "",

        @Past(message = "{validation.invalid.date}")
        var birthDate: LocalDate = LocalDate.now(),

        @CPF(message = "{validation.invalid.cpf}")
        var cpf: String = "",

        @Email(message = "{validation.invalid.email}")
        @NotBlank(message = "{validation.blank}")
        var email: String = "",

        @Pattern(regexp = "^[0-9]*", message = "{validation.phone}")
        @Size(min = 10, max = 11, message = "{validation.size}")
        var phone: String = "",

        @NotBlank(message = "{validation.blank}")
        var address: String = ""
) {
}