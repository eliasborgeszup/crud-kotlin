package com.crud.kotlin.first.domain.customer

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class CustomerService (
    private var repository: CustomerRepository
        ){


    fun getAll(page: Pageable): Page<Customer> {
        return repository.findAll(page)
    }
}