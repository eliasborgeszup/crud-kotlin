package com.crud.kotlin.first.domain.customer

import com.crud.kotlin.first.domain.customer.dtos.request.CreateCustomerDto
import com.crud.kotlin.first.domain.customer.dtos.response.CustomerDto
import com.crud.kotlin.first.domain.customer.dtos.response.CustomerIdDto
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus.*
import org.springframework.data.domain.Sort.Direction.ASC
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/customers")
class CustomerController(
    private var service: CustomerService
) {
    @ResponseStatus(CREATED)
    @PostMapping
    fun create(@RequestBody dto: CreateCustomerDto): CustomerIdDto {
        return CustomerIdDto(service.create(dto))
    }

    @ResponseStatus(OK)
    @GetMapping
    fun getAll(
        @PageableDefault(sort = ["name"], direction = ASC, size = 20)
        page: Pageable,
    ): Page<CustomerDto>{
        return service.getAll(page).map { CustomerDto().fromCustomer(it) }
    }
}