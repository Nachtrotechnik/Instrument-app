package com.thejourney.instrumentapp

import kotlin.math.pow

// 1. Enum class for Sharp/Flat/Natural indicator
enum class Accidental {
    NATURAL, // For notes like C, D, E, F, G, A, B
    SHARP,   // For notes like C#, D#, F#, G#, A#
    FLAT     // For notes like Db, Eb, Gb, Ab, Bb
}

data class Note(
    val name: String,         // "C", "D", "E", "F", "G", "A", "B"
    val accidental: Accidental, // NATURAL, SHARP, FLAT
    val octave: Int,          // e.g., 4 for C4 (Middle C)
    val keyNumber: Int        // The specific piano key number (1-88)
) {
    init {
        // 1. Validate keyNumber (already there, important base validation)
        require(keyNumber >= 1 && keyNumber <= 88) {
            "Note's keyNumber must be between 1 and 88 for a standard piano."
        }

        // 2. Validate note name format (must be A-G)
        val validNoteNames = setOf("A", "B", "C", "D", "E", "F", "G")
        require(name.uppercase() in validNoteNames) {
            "Note name must be one of: ${validNoteNames.joinToString(", ")} (case-insensitive)."
        }

        // 3. Validate plausible octave range for an 88-key piano
        // A standard 88-key piano usually spans from A0 to C.
        // So, octave 0 contains A0, A#0, B0. Octave 8 only contains C.
        require(octave >= 0 && octave <= 8) {
            "Octave must be between 0 and 8 for an 88-key piano."
        }

        // 4. Validate musically "impossible" or unconventional notes (common enharmonics)
        // This helps enforce standard musical notation rules for most cases.
        // It does NOT prevent C# and Db from both existing, as they are distinct logical notes
        // that map to the same physical key.
        when (name.uppercase()) {
            "E" -> require(accidental != Accidental.SHARP) {
                "E# is enharmonically F. Use Note(\"F\", Accidental.NATURAL, $octave, $keyNumber) instead."
            }

            "B" -> require(accidental != Accidental.SHARP) {
                "B# is enharmonically C. Use Note(\"C\", Accidental.NATURAL, ${octave + 1}, ${keyNumber}) instead (next octave)."
            }

            "C" -> require(accidental != Accidental.FLAT) {
                "Cb is enharmonically B. Use Note(\"B\", Accidental.NATURAL, ${octave - 1}, ${keyNumber}) instead (previous octave)."
            }

            "F" -> require(accidental != Accidental.FLAT) {
                "Fb is enharmonically E. Use Note(\"E\", Accidental.NATURAL, $octave, $keyNumber) instead."
            }
        }
        // Derived property: Frequence is calculated based on the key number
        val frequence: Double
        get() {
            // Reference frequency (A4 = 440 Hz)
            val A4_FREQUENCY = 440.0
            // The key number for A4 on an 88-key piano is typically 49 (from A0 as key 1)
            val A4_KEY_NUMBER = 49

            // 'n' is the number of semitones away from A4_KEY_NUMBER
            val n = (keyNumber - A4_KEY_NUMBER).toDouble()

            // Formula: f = f0 * 2^(n/12)
            // Where f0 is the reference frequency, n is semitones from f0, and 12 is semitones per octave
            return A4_FREQUENCY * (2.0.pow(n / 12.0))
        }

        // You can also add methods to convert the note to a display string if needed
        fun getDisplayName(): String {
            return when (accidental) {
                Accidental.SHARP -> "${name}#$octave"
                Accidental.FLAT -> "${name}b$octave"
                Accidental.NATURAL -> "$name$octave"
            }
        }
    }