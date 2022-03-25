package com.joseph.jmall.models

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import javax.persistence.*

@Entity
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int =0
    @Column
    var username =""
    @Column(unique = true)
    var email = ""
    @Column
    var password = ""
    get() = field
    set(value) {
        val bCryptPasswordEncodert = BCryptPasswordEncoder()
        field = bCryptPasswordEncodert.encode(value)
    }

    //check password matching
    fun comparePassword(password: String): Boolean{
        return BCryptPasswordEncoder().matches(password, this.password)
    }

}