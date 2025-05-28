package com.thejourney.instrumentapp


data class OctaveKey(
    val colouredKey: ColouredKey,
    val index: Int
) {
    init {
        require(index >= 0 && index <= 7)
    }
}

