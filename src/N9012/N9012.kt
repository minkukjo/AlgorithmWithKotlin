package N9012

import java.io.File
import java.util.*

fun isVPS(parenThesis: String): Boolean {
    val stack = Stack<Char>()

    for (c in parenThesis) {
        if(c == '(') {
            stack.push(c)
        }else if (c == ')') {
            if( stack.size == 0 ) {
                return false
            }
            val topParenThesis = stack.pop()

            if( topParenThesis != '(' ) {
                return false
            }
        }
    }
    if(stack.isNotEmpty()) {
        return false
    }
    return true;
}

fun main() = with(Scanner(System.`in`)) {
    val testCase = nextInt()

    for (i in 0 until testCase) {
        val parenThesis = next()
        if(isVPS(parenThesis)) {
            println("YES")
        }else {
            println("NO")
        }
    }
}