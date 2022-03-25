package com.joseph.jmall.services

import com.joseph.jmall.models.Product
import com.joseph.jmall.repositories.MarketRepository
import org.springframework.stereotype.Service


@Service
class ProductService(val repository: MarketRepository) {
    fun getAllProducts(): MutableIterable<Product> {
        return repository.findAll()
    }

    fun addProduct(product: Product): Product{
        return repository.save(product)
    }

    fun getProductById(id: Int): Product {
        return repository.findById(id)

    }
}