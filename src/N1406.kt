import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val initialStrings = StringBuffer(readLine())

    val stackLeft = Stack<Char>()
    val stackRight = Stack<Char>()

    initialStrings.forEach {
        stackLeft.add(it)
    }

    val inputCount = Integer.parseInt(readLine())
    for (i in 0 until inputCount) {
        val command = readLine()

        if (command.contains("P")) {
            stackLeft.add(command[2])
        } else {
            when (command) {
                "L" -> {
                    if (stackLeft.isNotEmpty()) {
                        stackRight.add(stackLeft.pop())
                    }
                }
                "D" -> {
                    if (stackRight.isNotEmpty()) {
                        stackLeft.add(stackRight.pop())
                    }
                }
                "B" -> {
                    if (stackLeft.isNotEmpty()) {
                        stackLeft.pop()
                    }
                }
            }
        }
    }

    while (stackLeft.isNotEmpty()) {
        stackRight.add(stackLeft.pop())
    }
    while (stackRight.isNotEmpty()) {
        print(stackRight.pop())
    }
}