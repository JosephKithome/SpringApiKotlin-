package com.joseph.jmall.controllers

import com.joseph.jmall.models.User
import com.joseph.jmall.services.UserService
import com.joseph.jmall.utils.Message
import com.joseph.jwtAuthKotlin.dtos.LoginDTO
import com.joseph.jwtAuthKotlin.dtos.UserDTO
import io.jsonwebtoken.Jwts
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import springfox.documentation.swagger2.annotations.EnableSwagger2
import java.util.*
import javax.servlet.http.Cookie
import javax.servlet.http.HttpServletResponse

@RestController
@EnableSwagger2
@RequestMapping("/api")
class AuthController(private val userService: UserService) {

    @PostMapping("register")
    fun registerUser(@RequestBody userDto: UserDTO): ResponseEntity<User> {
        val user = User()
        user.username = userDto.username
        user.email = userDto.email
        user.password = userDto.password

        return ResponseEntity.ok(this.userService.saveUser(user))
    }

    @PostMapping("login")
    fun login(@RequestBody body: LoginDTO, response: HttpServletResponse): ResponseEntity<Any> {
        val user = userService.findByEmail(body.email) ?: return ResponseEntity.badRequest().body(Message("User Not Found!"))
        if (!user.comparePassword(body.password )){
            return ResponseEntity.badRequest().body(Message("Incorrect password!"))
        }
        val issuer = user.id.toString()
        val jwt = Jwts.builder()
        jwt.setIssuer(issuer)
        jwt.setExpiration(Date(System.currentTimeMillis() + 60*24*1000))
//            jwt.signWith(SignatureAlgorithm.HS256,"secret")

        val cookie = Cookie("jwt", jwt.toString())
        cookie.isHttpOnly = true
        response.addCookie(cookie)
        return  ResponseEntity.ok(Message("Success"))
    }

    //Get authorized user
    @GetMapping("user")
    fun user(@CookieValue("jwt") jwt: String?): ResponseEntity<Any> {

        try {
            if (jwt == null) {
                return ResponseEntity.status(401).body(Message("Unauthorized"))
            }

            val body = Jwts.parser().setSigningKey("secret").parseClaimsJws(jwt).body

            return ResponseEntity.ok(this.userService.getById(body.issuer.toInt()))
        } catch (e: Exception) {
            return ResponseEntity.status(401).body(Message("Unauthorized"))
        }
    }
}