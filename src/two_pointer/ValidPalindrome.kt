package two_pointer

//link: https://leetcode.com/problems/valid-palindrome/

fun main() {
    println(isPalindrome("race a car"))
}

fun isPalindrome(s: String): Boolean {
    if (s.isEmpty()) return true

    var left = 0
    var right = s.length - 1

    while (left < right) {
        if (!s[left].isLetterOrDigit()) {
            left++
            continue
        }

        if (!s[right].isLetterOrDigit()) {
            right--
            continue
        }

        if (s[left].toLowerCase() != s[right].toLowerCase()) {
            return false
        }

        left++
        right--
    }

    return true
}