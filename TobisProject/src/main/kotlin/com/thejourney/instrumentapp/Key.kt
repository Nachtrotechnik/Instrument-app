package com.thejourney.instrumentapp

data class Key(
    val note: String,
    val number: Int,
    val frequence: Double
) {
    init {
        require(number >= 1 && number <= 88) { "Key number must be between1 and 88 for a standard Piano." }
    }

    //val MIN_FREQUENCY = 27.5
    //val MAX_FREQUENCY = 4186.009

    //require(frequence >= MIN_FREQUENCY && frequence <= MAX_FREQUENCY)
    //{ "Frequency must be betwenn $MIN_FREQUENCY Hz and $MAX_FREQUENCY Hz." }
}

