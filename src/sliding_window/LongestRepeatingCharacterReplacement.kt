package sliding_window

// link: https://leetcode.com/problems/longest-repeating-character-replacement/submissions/

fun main() {
    println(characterReplacement("ABAB", 2))
    println(characterReplacement("AABABBA", 1))
}

fun characterReplacement(s: String, k: Int): Int {
    var map = mutableMapOf<Char, Int>()

    var result = 0
    var maxFreq = 0
    var left = 0

    for (right in s.indices) {
        val c = s[right]
        map[c] = map.getOrDefault(c, 0) + 1

        maxFreq = Math.max(maxFreq, map[c]!!)

        while (((right - left + 1) - maxFreq) > k) {
            map[s[left]] = map[s[left]]!! - 1
            left++
        }
        result = Math.max(result, right - left + 1)
    }

    return result
}

