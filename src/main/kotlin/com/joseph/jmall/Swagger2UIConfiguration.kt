package com.joseph.jmall

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.PathSelectors.regex
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2


@Configuration
@EnableSwagger2
class Swagger2UIConfiguration {
    @Bean
    fun productApi(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
            .groupName("save")
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.joseph.jmall.controllers"))
//            .paths(PathSelectors.any())
            .paths(regex("/api.*"))
            .build()
            .apiInfo(metaData())
    }

    private fun metaData(): ApiInfo {
        return ApiInfo(
            "Spring Boot REST API",
            "Spring Boot REST API for Online Store",
            "1.0",
            "Terms of service",
            Contact("Joseph Kithome Thompson", "https://joseprofile.herokuapp.com", "jmulingwakithome.jmk@gmail.com").toString(),
            "Apache License Version 2.0",
            "https://www.apache.org/licenses/LICENSE-2.0"
        )
    }
}