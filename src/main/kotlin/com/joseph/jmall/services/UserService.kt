package com.joseph.jmall.services

import com.joseph.jmall.models.User
import com.joseph.jmall.repositories.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {

    fun saveUser(user: User): User {
        return  this.userRepository.save(user)
    }
    fun findByEmail(email: String?): User{
        return  this.userRepository.findByEmail(email)
    }
    fun getById(id: Int): User{
        return userRepository.getById(id)
    }
}