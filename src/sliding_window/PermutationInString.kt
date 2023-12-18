package sliding_window

// 567. Permutation in String
// link: https://leetcode.com/problems/permutation-in-string/

fun main() {
    println("All test cases must print true")
    println(checkInclusion("ab", "eidbaooo") == true)
    println(checkInclusion("ab", "eidboaoo") == false)
    println(checkInclusion("hello", "jhsgleholsdaheso") == true)
    println(checkInclusion("a", "ab") == true)
    println(checkInclusion("adc", "dcda") == true)
}

fun checkInclusion(s1: String, s2: String): Boolean {
    if (s1.length > s2.length)
        return false

    val s1map = IntArray(26)
    val s2map = IntArray(26)

    for (i in s1.indices) {
        s1map[s1[i] - 'a']++
        s2map[s2[i] - 'a']++
    }

    var count = 0
    for (i in 0 until 26)
        if (s1map[i] == s2map[i]) count++


    for (i in 0 until s2.length - s1.length) {
        val r = s2[i + s1.length] - 'a'
        val l = s2[i] - 'a'

        if (count == 26) return true

        s2map[r]++

        if (s2map[r] == s1map[r])
            count++
        else if (s2map[r] == s1map[r] + 1)
            count--

        s2map[l]--

        if (s2map[l] == s1map[l])
            count++
        else if (s2map[l] == s1map[l] - 1)
            count--
    }
    return count == 26
}

// work in progress
fun hasPermutation(s1: String, s2: String): Boolean {

    if (s1.length > s2.length) return false


    val k = s1.length
    val maps1 = mutableMapOf<Char, Int>()
    val maps2 = mutableMapOf<Char, Int>()

    // map 1
    for (i in 0 until s1.length) {
        if (maps1.containsKey(s1[i]))
            maps1[s1[i]] = maps1[s1[i]]!! + 1
        else
            maps1[s1[i]] = 1
    }

    for (i in 0 until k) {
        if (maps2.containsKey(s2[i]))
            maps2[s2[i]] = maps2[s2[i]]!! + 1
        else
            maps2[s2[i]] = 1
    }

    for (i in k until s2.length) {
        maps2[s2[i - k]] = maps2[s2[i - k]]!! - 1

        if (maps2[s2[i - k]] == 0) maps2.remove(s2[i - k])

        if (maps2.containsKey(s2[i]))
            maps2[s2[i]] = maps2[s2[i]]!! + 1
        else
            maps2[s2[i]] = 1

        if (maps1 == maps2) return true
    }

    return false
}