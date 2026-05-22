package com.raellacerda.uri2621.repositories



import com.raellacerda.uri2621.entities.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface ProductRepository : JpaRepository<Product, Long> {
    @Query(
        nativeQuery = true,
        value = """
            SELECT prod.name
            FROM products AS prod
            INNER JOIN providers AS prov on prod.id_providers = prov.id
            WHERE prod.amount BETWEEN :min AND :max
            AND prov.name LIKE 'P%'
        """
    )
    fun findByAmountRange(
        @Param("min") min: Int,
        @Param("max") max: Int
    ): List<String>

    @Query("SELECT obj.name FROM Product obj JOIN obj.provider WHERE obj.amount BETWEEN :min AND :max AND obj.provider.name LIKE 'P%'")
    fun findByAmountRangeJPQL(
        @Param("min") min: Int,
        @Param("max") max: Int
    ): List<String>
}