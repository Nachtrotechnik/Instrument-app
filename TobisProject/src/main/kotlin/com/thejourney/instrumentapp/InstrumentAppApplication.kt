package com.thejourney.instrumentapp // This MUST be the very first line

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

// This is your main Spring Boot application class
@SpringBootApplication
class InstrumentAppApplication

// This is the main function that starts the Spring Boot application
fun main(args: Array<String>) {
    runApplication<InstrumentAppApplication>(*args)
}
