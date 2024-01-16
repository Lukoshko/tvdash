package ru.belkacar.pumper.tvdash.rent.service

import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate
import java.time.Duration

@Configuration
class Configuration {
    @Bean
    fun restTemplate(builder: RestTemplateBuilder): RestTemplate {
        return builder
            .setConnectTimeout(Duration.ofMillis(3000))
            .setReadTimeout(Duration.ofMillis(3000))
            .defaultHeader("x-client", "12345678-90ab-416b-cdef-1234567890ab - One Spell to Rule Them All")
            .defaultHeader("x-api-user", "9d1576db-e881-4477-b017-ad4c9bb2512e")
            .defaultHeader("x-api-key", "f98ccb43-f0d4-4b6d-8e31-b22ccba0d3af")
            .build()
    }
}