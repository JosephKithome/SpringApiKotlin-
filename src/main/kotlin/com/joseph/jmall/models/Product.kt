package com.joseph.jmall.models

import javax.persistence.*

@Entity
class Product{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int =0
    @Column
    var name =""
    @Column(unique = true)
    var price = ""

}