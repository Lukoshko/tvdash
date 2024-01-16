package ru.belkacar.pumper.tvdash

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication


@SpringBootApplication
@ConfigurationPropertiesScan
class TvDashboardApplication

fun main(args: Array<String>) {
    runApplication<TvDashboardApplication>(*args)
}
