package com.crud.kotlin.first.domain.customer

import com.crud.kotlin.first.domain.customer.dtos.request.CreateCustomerDto
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class CustomerService (
    private var repository: CustomerRepository
        ){

    fun create(dto: CreateCustomerDto): String {
        //LOG
        return Customer().create(dto, repository)
    }

    fun getAll(page: Pageable): Page<Customer> {
        return repository.findAll(page)
    }


}