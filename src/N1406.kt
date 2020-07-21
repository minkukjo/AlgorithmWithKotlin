import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val initialStrings = StringBuffer("0" + next() + "1")
    var cursor = initialStrings.length - 1
    val inputCount = nextInt()
    for (i in 0 until inputCount) {
        val command = next()

        when (command[0]) {
            'P' -> {
                val inputChar = next()
                cursor += 1
                initialStrings.insert(cursor, inputChar)
            }
            'L' -> {
                if (initialStrings[cursor] != '0') {
                    cursor -= 2
                }
            }
            'D' -> {
                if (initialStrings[cursor] != '1') {
                    cursor += 2
                }
            }
            'B' -> {
                if (initialStrings[cursor] != '0' && initialStrings[cursor - 1] != '0') {
                    cursor -= 1
                    initialStrings.deleteCharAt(cursor)
                }
            }
        }
    }

    initialStrings.deleteCharAt(0)
    initialStrings.deleteCharAt(initialStrings.length - 1)
    println(initialStrings)
}