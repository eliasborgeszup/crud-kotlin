package com.crud.kotlin.first.domain.customer

import com.crud.kotlin.first.domain.customer.dtos.request.CreateCustomerDto
import com.crud.kotlin.first.domain.customer.dtos.request.UpdateCustomerDto
import com.crud.kotlin.first.exception.DocumentAlreadyExistsException
import com.crud.kotlin.first.exception.NotFoundException
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class CustomerService (
    private var repository: CustomerRepository
        ){

    fun create(dto: CreateCustomerDto): String {
        if(repository.existsByCpf(dto.cpf)){
            //Log
            throw DocumentAlreadyExistsException(
                String.format("CustomerServiceImpl: create, customer = %s register",
                    dto.cpf));
        }

        return Customer().create(dto, repository)
    }

    fun getAll(page: Pageable): Page<Customer> {
        return repository.findAll(page)
    }

    fun getByCpf(cpf: String): Customer {
        return repository.findByCpf(cpf).orElseThrow {
            //Log
            throw NotFoundException(
                String.format("CustomerServiceImpl: findByCpf, cpf customer = %s not found", cpf)
            ) }
    }

    fun update(cpf: String, dto: UpdateCustomerDto): String {
        val customer: Customer = repository.findByCpf(cpf).orElseThrow {
            //Log
            throw NotFoundException(
                String.format("CustomerServiceImpl: findByCpf, cpf customer = %s not found", cpf)
            ) }

        return customer.update(dto, repository)
    }

    fun delete(cpf: String) {
        val customer: Customer = repository.findByCpf(cpf).orElseThrow {
            //Log
            throw NotFoundException(
                String.format("CustomerServiceImpl: findByCpf, cpf customer = %s not found", cpf)
            ) }

        return customer.delete(customer, repository)
    }


}