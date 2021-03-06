package com.crud.kotlin.first.domain.customer

import java.time.LocalDate
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

    @Column(nullable = false)
    var birtDate: LocalDate,

    @Column(nullable = false, unique = true, length = 11)
    var cpf: String = "",

    @Column(nullable = false)
    var email: String = "",

    @Column(nullable = false, length = 11)
    var phone: String = "",

    @Column(nullable = false)
    var address: String = "",
) {
}