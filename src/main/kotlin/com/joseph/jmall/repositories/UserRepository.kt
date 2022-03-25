package com.joseph.jmall.repositories

import com.joseph.jmall.models.User
import org.springframework.data.annotation.Id
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Id> {

    //find user by id
     fun getById(id: Int): User
    //find user by email
    fun findByEmail(email: String?): User
}