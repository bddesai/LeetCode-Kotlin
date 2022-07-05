package sliding_window

// link : https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/

fun main() {
    println(maxVowels("abciiidef", 3))
    println(maxVowels("aeiou", 2))
    println(maxVowels("leetcode", 3))
}

fun maxVowels(s: String, k: Int): Int {

    var numVowels = 0
    for (i in 0 until k) {
        if (s[i].isVowel())
            numVowels++
    }

    var globalMax = numVowels

    for (i in k until s.length) {

        if (s[i].isVowel())
            numVowels++

        if (s[i-k].isVowel())
            numVowels--


        globalMax = Math.max(globalMax, numVowels)
    }
    return globalMax
}
// time : O(n)
// space: O(1)


// extension function
fun Char.isVowel(): Boolean {
    val set = setOf('a', 'e', 'i', 'o', 'u')
    if (this in set) {
        return true
    }
    return false
}