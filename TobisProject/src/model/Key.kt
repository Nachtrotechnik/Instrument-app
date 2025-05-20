package model

data class Key(
    val note: String,
)

data class ColouredKey(
    val key: Key,
    val color: Color
)


data class OctaveKey(
    val colouredKey: ColouredKey,
    val index: Int
)

enum class Color{
    WHITE, BLACK
}
