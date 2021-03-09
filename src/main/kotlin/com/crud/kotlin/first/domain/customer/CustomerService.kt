package com.crud.kotlin.first.domain.customer

import com.crud.kotlin.first.domain.customer.dtos.request.CreateCustomerDto
import com.crud.kotlin.first.domain.customer.dtos.request.UpdateCustomerDto
import com.crud.kotlin.first.exception.DocumentAlreadyExistsException
import com.crud.kotlin.first.exception.NotFoundException
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

private val log: Logger = LoggerFactory.getLogger(CustomerService::class.java)

@Service
class CustomerService (
    private var repository: CustomerRepository
        ){

    fun create(dto: CreateCustomerDto): String {
        if(repository.existsByCpf(dto.cpf)){
            log.error("Customer not created, customer CPF = {} register", dto.cpf)

            throw DocumentAlreadyExistsException(
                String.format("CustomerServiceImpl: create, customer = %s register",
                    dto.cpf));
        }
        log.info("Create customer = {}", dto)
        return Customer().create(dto, repository)
    }

    fun getAll(page: Pageable): Page<Customer> {
        return repository.findAll(page)
    }

    fun getByCpf(cpf: String): Customer {
        return repository.findByCpf(cpf).orElseThrow {
            log.error("Customer not found, customer CPF = {} not found", cpf)

            throw NotFoundException(
                String.format("CustomerServiceImpl: findByCpf, customer CPF = %s not found", cpf)
            ) }
    }

    fun update(cpf: String, dto: UpdateCustomerDto): String {
        val customer: Customer = repository.findByCpf(cpf).orElseThrow {
            log.error("Costumer not update, costumer = {} not found", cpf)

            throw NotFoundException(
                String.format("CustomerServiceImpl: findByCpf, customer CPF = %s not found", cpf)
            ) }

        log.info("Update customer, cpf = {}, customerBefore = {}, customerAfter = {}",
                cpf,
                dto,
                customer);

        return customer.update(dto, repository)
    }

    fun delete(cpf: String) {
        val customer: Customer = repository.findByCpf(cpf).orElseThrow {
            log.error("Customer not delete, customer CPF = {} not found", cpf)

            throw NotFoundException(
                String.format("CustomerServiceImpl: findByCpf, customer CPF = %s not found", cpf)
            ) }

        log.info("Delete customer = {}", customer)

        return customer.delete(customer, repository)
    }


}