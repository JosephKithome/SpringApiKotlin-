package com.joseph.jmall.controllers

import com.joseph.jmall.dto.ProductDTO
import com.joseph.jmall.exceptions.JmallNotFoundException
import com.joseph.jmall.models.Product
import com.joseph.jmall.services.ProductService
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import springfox.documentation.swagger2.annotations.EnableSwagger2

@RestController
@EnableSwagger2
@RequestMapping("/api")

class MainController(val service: ProductService) {

    @Value("\${company_name}")
    private lateinit var name: String
//    var products = mutableListOf(
//        Product(1, "CryptoPunks", 100.0),
//        Product(2, "Sneaky Vampire Syndicate", 36.9),
//        Product(3, "The Sevens (Official)", 0.6),
//        Product(4, "Art Blocks Curated", 1.1),
//        Product(5, "Pudgy Penguins", 2.5),
//    )

    @GetMapping("homepage")
    fun getHomePage() = "$name: JMall Marketplace"

    @GetMapping("products")
    fun getAllProducts(): MutableIterable<Product> {

        return service.getAllProducts()
    }

    //post a product
    @PostMapping("product")
    @ResponseStatus(HttpStatus.CREATED)
    fun addProduct(@RequestBody productDTO: ProductDTO): ResponseEntity<Product>{
        val product = Product()
        product.price = productDTO.price.toString()
        product.name = productDTO.name
        return ResponseEntity.ok(this.service.addProduct(product))

    }

    //get product by id
    @GetMapping("product/{id}")
    fun getProduct(@PathVariable id: Int): ResponseEntity<Product>{
        return ResponseEntity.ok(this.service.getProductById(id))
    }
}