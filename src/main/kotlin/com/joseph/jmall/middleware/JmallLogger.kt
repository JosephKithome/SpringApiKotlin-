package com.joseph.jmall.middleware

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import javax.servlet.Filter
import javax.servlet.FilterChain
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse


@Component
class JmallLogger: Filter {
    val loggerFactory = LoggerFactory.getLogger("JMALL LOGGER")

    override fun doFilter(
        servletRequest: ServletRequest,
        servletResponse: ServletResponse,
        filterChain: FilterChain
    ) {
        val utmSource = servletRequest.getParameter("utm_source")
        loggerFactory.info("Logging UTM source: $utmSource")
        filterChain.doFilter(servletRequest, servletResponse)
    }

}