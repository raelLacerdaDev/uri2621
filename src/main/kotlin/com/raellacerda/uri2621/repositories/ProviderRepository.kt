package com.raellacerda.uri2621.repositories

import com.raellacerda.uri2621.dtos.ProductMinDto
import com.raellacerda.uri2621.entities.Provider
import org.springframework.data.jpa.repository.JpaRepository

interface ProviderRepository : JpaRepository<Provider, Long>