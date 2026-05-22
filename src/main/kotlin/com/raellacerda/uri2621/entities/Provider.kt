package com.raellacerda.uri2621.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import lombok.EqualsAndHashCode

@Entity
@Table(name = "providers")
@EqualsAndHashCode
class Provider(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long? = null,
    val name : String,
    val street : String,
    val city : String,
    val state : String,
    @OneToMany(mappedBy = "provider")
    private val _products: MutableList<Product> = mutableListOf()
){
    val products : List<Product> get() = _products.toList()
}