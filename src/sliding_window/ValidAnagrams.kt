package sliding_window

// https://leetcode.com/problems/valid-anagram/submissions/

fun main() {
    println(isAnagram("anagram", "nagaram"))
    println(isAnagram("rat", "car"))
}

fun isAnagram(s: String, t: String): Boolean {
    if (s.length != t.length) return false

    val arr = Array(26) { 0 }

    for (c in s.toCharArray()) arr[c - 'a']++

    for (c in t.toCharArray()) arr[c - 'a']--

    for (i in 0 until 26)
        if (arr[i] != 0) return false

    return true
}
