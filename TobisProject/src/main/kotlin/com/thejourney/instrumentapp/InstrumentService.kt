package com.thejourney.instrumentapp

import org.springframework.stereotype.Service
import com.thejourney.instrumentapp.ColouredKey
import com.thejourney.instrumentapp.Key
import com.thejourney.instrumentapp.Color
import com.thejourney.instrumentapp.Note
import com.thejourney.instrumentapp.OctaveKey
import com.thejourney.instrumentapp.PianoConstants.kt
import com.thejourney.instrumentapp.OCTAVE_SEMITONES_INFO
import com.thejourney.instrumentapp.MIDI_NOTE_A0


// We'll put your model imports here explicitly for clarity,
// assuming they are in the same package (com.thejourney.instrumentapp)
// If you explicitly defined a 'model' package WITHIN com.thejourney.instrumentapp
// (e.g., src/main/kotlin/com/thejourney/instrumentapp/model/Key.kt),
// then you'd use import com.thejourney.instrumentapp.model.*
// For now, assuming all are in the same package as per current setup.
// If these imports are red in your IDE later, you might need to change them.

@Service // This annotation tells Spring to manage this class as a service
class InstrumentService {

    fun getPianoKeys(): List<OctaveKey> {
        val pianoKeysList = mutableListOf<OctaveKey>()

        // MIDI_NOTE_A0 is now imported from PianoConstants.kt
        // val MIDI_NOTE_A0 = 21 // THIS LINE IS REMOVED

        // Loop through all 88 keys of the piano
        for (keyNum in 1..88) {
            val midiNote = MIDI_NOTE_A0 + (keyNum - 1)
            val musicalOctave = (midiNote / 12) - 1
            val semitoneIndexInOctave = midiNote % 12

            // OCTAVE_SEMITONES_INFO is now imported from PianoConstants.kt
            val semitoneInfo = OCTAVE_SEMITONES_INFO[semitoneIndexInOctave]

            val note = Note(
                name = semitoneInfo.name,
                accidental = semitoneInfo.accidental,
                octaveNumber = musicalOctave,
                keyNumber = keyNum
            )

            val musicalKey = Key(note)
            val keyWithColor = ColouredKey(key, semitoneInfo.color)
            val octaveKey = OctaveKey(colouredKey, musicalOctave)

            pianoKeysList.add(octaveKey)
        }

        return pianoKeysList
    }
