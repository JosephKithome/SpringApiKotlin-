package com.joseph.jmall

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.web.servlet.config.annotation.EnableWebMvc


@EnableWebMvc
@SpringBootApplication (exclude = [SecurityAutoConfiguration::class])
class SpringRelationshipsApplication

fun main(args: Array<String>) {
	runApplication<SpringRelationshipsApplication>(*args)
}
