package com.crud.kotlin.first.domain.customer

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CustomerRepository: JpaRepository<Customer, String> {
    fun existsByCpf(cpf: String): Boolean

    fun findByCpf(cpf: String): Optional<Customer>
}