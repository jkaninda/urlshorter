package com.github.jkaninda.urlshorter.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration

@Configuration
class AppConfig {

    @Value(value = "\${url.length}")
    val urlLength: Int=10
    @Value(value = "\${domain.url}")
    val domainURL: String="http://localhost"
    @Value(value = "\$spring.application.name}")
    val appName:String="URL Shorter"

}