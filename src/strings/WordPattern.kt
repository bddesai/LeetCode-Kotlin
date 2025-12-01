package strings

//290. Word Pattern
//Link: https://leetcode.com/problems/word-pattern/


fun main() {
    // Example 1: True (Perfect bijection)
    val pattern1 = "abba"
    val str1 = "dog cat cat dog"
    println("\"$pattern1\" matches \"$str1\": ${wordPattern(pattern1, str1)}") // Output: true

    // Example 2: False (Pattern 'a' mapped to 'dog', then 'a' mapped to 'cat')
    val pattern2 = "abba"
    val str2 = "dog cat cat fish"
    println("\"$pattern2\" matches \"$str2\": ${wordPattern(pattern2, str2)}") // Output: false

    // Example 3: False (Word 'dog' mapped to 'a', then 'dog' mapped to 'b')
    val pattern3 = "aaaa"
    val str3 = "car car car plane"
    println("\"$pattern3\" matches \"$str3\": ${wordPattern(pattern3, str3)}") // Output: false

    // Example 4: False (Length mismatch)
    val pattern4 = "aba"
    val str4 = "plane car plane"
    println("\"$pattern4\" matches \"$str4\": ${wordPattern(pattern4, str4)}") // Output: false
}

fun wordPattern(pattern: String, s: String): Boolean {
    val words = s.split(" ")

    if (pattern.length != words.size) return false

    val patternToWordMap = mutableMapOf<Char, String>()
    val wordToPatternMap = mutableMapOf<String, Char>()

    for (i in pattern.indices) {
        val c = pattern[i]
        val word = words[i]
        if (patternToWordMap.containsKey(c)) {
            if (patternToWordMap[c] != word) return false
        } else {
            patternToWordMap[c] = word
        }

        if (wordToPatternMap.containsKey(word)) {
            if (wordToPatternMap[word] != c) return false
        } else {
            wordToPatternMap[word] = c
        }
    }
    return true
}