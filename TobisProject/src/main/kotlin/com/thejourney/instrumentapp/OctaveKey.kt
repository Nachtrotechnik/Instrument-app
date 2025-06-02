package com.thejourney.instrumentapp


data class OctaveKey(
    val keyWithColor: ColouredKey,
    val octaveNumber: Int
) {
    init {
        require(index >= 0 && index <= 7)
    }
}

