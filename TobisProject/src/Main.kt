import model.*

fun main() {
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

    val guitar = Guitar(
        listOf(
            Key("E"),
            Key("F"),
            Key("F#"),
        )
    )

    println("Piano keys:")

    for (octaveKey in piano.keys) {
        println("Key:" + octaveKey.colouredKey.key.note)
    }

    println()
    println("Guitar keys:")

    for (key in guitar.stringedKey) {
        println("Key:" + key.note)
    }
}