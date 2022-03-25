package com.joseph.jmall.repositories

import com.joseph.jmall.models.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import javax.persistence.Id

interface MarketRepository: CrudRepository<Product,Id> {

    fun findById(id: Int): Product

}