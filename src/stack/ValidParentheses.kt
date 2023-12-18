import java.util.*

// link: https://leetcode.com/problems/valid-parentheses/

fun main() {
    println(isValid("()[]{}"))
    println(isValid("()[}"))
}

fun isValid(s: String): Boolean {
    val stack = ArrayDeque<Char>()

    val map = hashMapOf<Char, Char>(
        ')' to '(',
        '}' to '{',
        ']' to '['
    )

    for (i in s.indices) {
        if (map.containsKey(s[i])) {
            if (stack.isEmpty() || stack.pop() != map[s[i]])
                return false
        } else {
            stack.push(s[i])
        }
    }
    return stack.isEmpty()
}

fun isValid2(s: String): Boolean {

    val stack = Stack<Char>()
    for (char in s) {
        when (char) {
            '(', '{', '[' -> stack.push(char)
            ')' -> if (stack.isEmpty() || stack.pop() != '(') return false
            '}' -> if (stack.isEmpty() || stack.pop() != '{') return false
            ']' -> if (stack.isEmpty() || stack.pop() != '[') return false

        }
    }
    return stack.isEmpty()
}

