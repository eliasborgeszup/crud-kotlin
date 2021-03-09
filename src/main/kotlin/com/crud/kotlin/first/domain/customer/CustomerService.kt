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
import java.util.*

@Service
class CustomerService(
        private var repository: CustomerRepository
) {
    private val log: Logger = LoggerFactory.getLogger(CustomerService::class.java)

    fun create(dto: CreateCustomerDto): String {
        if (repository.existsByCpf(dto.cpf)) {
            log.error("Customer not created, customer CPF = ${dto.cpf} register")

            throw DocumentAlreadyExistsException(
                    "CustomerServiceImpl: create, customer = ${dto.cpf} register"
            )
        }
        log.info("Create customer = $dto")
        return Customer.create(dto, repository)
    }

    fun getAll(page: Pageable): Page<Customer> {
        return repository.findAll(page)
    }

    fun getByCpf(cpf: String): Customer {
        return repository.findByCpf(cpf).orElseThrow {
            log.error("Customer not found, customer CPF = $cpf not found")

            throw NotFoundException(
                    "CustomerServiceImpl: findByCpf, customer CPF = $cpf not found"
            )
        }
    }

    fun update(cpf: String, dto: UpdateCustomerDto): String {
        val customer: Customer = repository.findByCpf(cpf).orElseThrow {
            log.error("Costumer not update, costumer = $cpf not found")

            throw NotFoundException(
                    "CustomerServiceImpl: findByCpf, customer CPF = $cpf not found"
            )
        }

        log.info("Update customer, cpf = $cpf, customerBefore = $dto, customerAfter = $customer");

        return Customer.update(
                Customer(
                        customer.id,
                        dto.name,
                        dto.birthDate,
                        customer.cpf,
                        dto.email,
                        dto.phone,
                        dto.address
                ), repository)
    }

    fun delete(cpf: String) {
        val customer: Customer = repository.findByCpf(cpf).orElseThrow {
            log.error("Customer not delete, customer CPF = $cpf not found")

            throw NotFoundException(
                    "CustomerServiceImpl: findByCpf, customer CPF = $cpf not found"
            )
        }

        log.info("Delete customer = $customer")

        return customer.delete(customer, repository)
    }
}