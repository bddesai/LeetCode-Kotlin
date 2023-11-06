package two_pointer

// link: https://leetcode.com/problems/valid-palindrome-ii/

fun main() {
    // Test cases
    println(isPalindromeII("aba")) // Output: true
    println(isPalindromeII("abca")) // Output: true
    println(isPalindromeII("abc")) // Output: false
}

fun isPalindromeII(s: String): Boolean {
    var left = 0
    var right = s.length - 1
    while (left < right) {
        if (s[left] != s[right]) {
            return isPalindromeRange(s, left + 1, right) || isPalindromeRange(s, left, right - 1)
        }
        left++
        right--
    }
    return true
}

fun isPalindromeRange(str: String, i: Int, j: Int): Boolean {
    var start = i
    var end = j
    while (start < end) {
        if (str[start] != str[end]) {
            return false
        }
        start++
        end--
    }
    return true
}