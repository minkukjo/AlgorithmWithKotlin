import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val initialStrings = StringBuffer(next())

    val stackLeft = Stack<Char>()
    val stackRight = Stack<Char>()

    initialStrings.forEach {
        stackLeft.add(it)
    }

    val inputCount = nextInt()
    for (i in 0 until inputCount) {
        val command = next()[0]

        when (command) {
            'P' -> {
                val inputChar = next()[0]
                stackLeft.add(inputChar)
            }
            'L' -> {
                if(stackLeft.isNotEmpty()) {
                    stackRight.add(stackLeft.pop())
                }
            }
            'D' -> {
                if(stackRight.isNotEmpty()){
                    stackLeft.add(stackRight.pop())
                }
            }
            'B' -> {
                if(stackLeft.isNotEmpty()){
                    stackLeft.pop()
                }
            }
        }
    }

    while(stackLeft.isNotEmpty()) {
        stackRight.add(stackLeft.pop())
    }
    while(stackRight.isNotEmpty()){
        print(stackRight.pop())
    }
}