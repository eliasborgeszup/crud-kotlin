package com.crud.kotlin.first.domain.customer

import com.crud.kotlin.first.domain.customer.dtos.request.CreateCustomerDto
import com.crud.kotlin.first.domain.customer.dtos.request.UpdateCustomerDto
import java.time.LocalDate
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Customer(
    @Id
    @Column(updatable = false, unique = true, nullable = false)
    var id: String = "",

    @Column(nullable = false)
    var name: String = "",

    //TODO: LocalDate
    @Column(nullable = false)
    var birthDate: LocalDate = LocalDate.now(),

    @Column(nullable = false, unique = true, length = 11)
    var cpf: String = "",

    @Column(nullable = false)
    var email: String = "",

    @Column(nullable = false, length = 11)
    var phone: String = "",

    @Column(nullable = false)
    var address: String = "",
) {
    fun create(dto: CreateCustomerDto, repository: CustomerRepository): String {
        this.id = UUID.randomUUID().toString()
        this.name = dto.name
        this.birthDate = dto.birthDate
        this.cpf = dto.cpf
        this.email = dto.email
        this.phone = dto.phone
        this.address = dto.address
        //Log
        return repository.save(this).id
    }

    fun update(dto: UpdateCustomerDto, repository: CustomerRepository): String {
        this.name = dto.name
        this.birthDate = dto.birthDate
        this.email = dto.email
        this.phone = dto.phone
        this.address = dto.address
        //Log
        return repository.save(this).id
    }

    fun delete(customer: Customer, repository: CustomerRepository) {
        //Log
        repository.delete(customer)
    }

}