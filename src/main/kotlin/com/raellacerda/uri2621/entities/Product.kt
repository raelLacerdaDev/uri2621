package com.raellacerda.uri2621.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import lombok.EqualsAndHashCode

@Entity
@Table(name = "products")
@EqualsAndHashCode
class Product(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name : String,
    val price : Double,
    val amount: Int,

    @ManyToOne
    @JoinColumn(name = "id_providers", nullable = false)
    val provider: Provider
)