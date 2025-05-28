package com.thejourney.instrumentapp

import org.springframework.stereotype.Service

// We'll put your model imports here explicitly for clarity,
// assuming they are in the same package (com.thejourney.instrumentapp)
// If you explicitly defined a 'model' package WITHIN com.thejourney.instrumentapp
// (e.g., src/main/kotlin/com/thejourney/instrumentapp/model/Key.kt),
// then you'd use import com.thejourney.instrumentapp.model.*
// For now, assuming all are in the same package as per current setup.
// import com.thejourney.instrumentapp.ColouredKey
// import com.thejourney.instrumentapp.Key
// import com.thejourney.instrumentapp.Color
// import com.thejourney.instrumentapp.Piano
// import com.thejourney.instrumentapp.OctaveKey
// import com.thejourney.instrumentapp.Guitar
// If these imports are red in your IDE later, you might need to change them.

@Service // This annotation tells Spring to manage this class as a service
class InstrumentService {

    fun getPianoKeys(): List<String> {
        val cKey = ColouredKey(Key("C"), Color.WHITE)
        val cSharpKey = ColouredKey(Key("C#"), Color.BLACK)
        val dKey = ColouredKey(Key("D"), Color.WHITE)

        val piano = Piano(
            listOf(
                OctaveKey(cKey, 1),
                OctaveKey(cSharpKey, 1),
                OctaveKey(dKey, 1),
                OctaveKey(cKey, 2)
            )
        )
        val keys = mutableListOf<String>()
        for (octaveKey in piano.keys) {
            keys.add("Piano Key: " + octaveKey.colouredKey.key.note + " (Octave: " + octaveKey.index + ")")
        }
        return keys
    }

    fun getGuitarKeys(): List<String> {
        val guitar = Guitar(
            listOf(
                Key("E"),
                Key("F"),
                Key("F#"),
            )
        )
        val keys = mutableListOf<String>()
        for (key in guitar.stringedKey) {
            keys.add("Guitar Key: " + key.note)
        }
        return keys
    }
}
