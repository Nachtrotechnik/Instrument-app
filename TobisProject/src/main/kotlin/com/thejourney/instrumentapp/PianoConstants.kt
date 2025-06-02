package com.thejourney.instrumentapp

import com.thejourney.instrumentapp.Accidental
import com.thejourney.instrumentapp.Color
import com.thejourney.instrumentapp.Note

data class SemitoneInfo(
    val name: String,
    val accidental: Accidental,
    val color: Color
    )
val OCTAVE_SEMITONES_INFO = listOf(
    SemitoneInfo("C", Accidental.NATURAL, Color.WHITE), // 0
    SemitoneInfo("C", Accidental.SHARP, Color.BLACK),   // 1 (or Db)
    SemitoneInfo("D", Accidental.NATURAL, Color.WHITE), // 2
    SemitoneInfo("D", Accidental.SHARP, Color.BLACK),   // 3 (or Eb)
    SemitoneInfo("E", Accidental.NATURAL, Color.WHITE), // 4
    SemitoneInfo("F", Accidental.NATURAL, Color.WHITE), // 5
    SemitoneInfo("F", Accidental.SHARP, Color.BLACK),   // 6 (or Gb)
    SemitoneInfo("G", Accidental.NATURAL, Color.WHITE), // 7
    SemitoneInfo("G", Accidental.SHARP, Color.BLACK),   // 8 (or Ab)
    SemitoneInfo("A", Accidental.NATURAL, Color.WHITE), // 9
    SemitoneInfo("A", Accidental.SHARP, Color.BLACK),   // 10 (or Bb)
    SemitoneInfo("B", Accidental.NATURAL, Color.WHITE)  // 11
)

// A0 (the first key on an 88-key piano) corresponds to MIDI note number 21.
const val MIDI_NOTE_A0 = 21