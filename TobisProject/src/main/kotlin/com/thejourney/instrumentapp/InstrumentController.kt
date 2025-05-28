package com.thejourney.instrumentapp

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

// Import the InstrumentService
import com.thejourney.instrumentapp.InstrumentService // Explicit import

@RestController
class InstrumentController(private val instrumentService: InstrumentService) { // Spring will automatically inject InstrumentService here

    @GetMapping("/")
    fun helloInstruments(): String {
        return "Welcome to the Instrument App API! Check /piano-keys or /guitar-keys for data."
    }

    @GetMapping("/piano-keys") // New endpoint for piano keys
    fun getPianoKeys(): List<String> {
        return instrumentService.getPianoKeys() // Call the service method
    }

    @GetMapping("/guitar-keys") // New endpoint for guitar keys
    fun getGuitarKeys(): List<String> {
        return instrumentService.getGuitarKeys() // Call the service method
    }

    @GetMapping("/status") // Keep the original status endpoint
    fun status(): String {
        return "Instrument App is running and healthy!"
    }
}
