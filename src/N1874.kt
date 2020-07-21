import java.lang.Integer.max
import java.util.*

var maxValue = 0

fun main() = with(Scanner(System.`in`)) {
    val inputSize = nextInt()
    val stack = Stack<Int>()
    val answers = mutableListOf<Char>()

    for ( i in 0 until inputSize) {
        val value = nextInt()
        if(stack.isEmpty() || stack.peek() < value) {
            for(j in (maxValue+1)..value) {
                answers.add('+')
                stack.push(j)
            }
        }

        maxValue = max(maxValue,value)

        if(stack.peek() == value){
            answers.add('-')
            stack.pop()
        }else {
            println("NO")
            return
        }
    }

    answers.forEach {
        println(it)
    }

}