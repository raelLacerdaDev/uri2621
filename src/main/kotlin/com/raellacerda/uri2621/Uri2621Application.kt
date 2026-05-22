package com.raellacerda.uri2621

import com.raellacerda.uri2621.repositories.ProductRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Uri2621Application(val productRepository: ProductRepository) : CommandLineRunner {
    override fun run(vararg args: String) {
        val products = productRepository.findByAmountRange(10,20)

        for (product in products) {
            println(product)
        }
    }
}

fun main(args: Array<String>) {
    runApplication<Uri2621Application>(*args)
}
