package sliding_window

// link: https://leetcode.com/problems/find-all-anagrams-in-a-string/

fun main() {
    println(findAnagrams("cbaebabacd", "abc"))
    println(findAnagrams("abab", "ab"))
    println(findAnagrams("aaaaaaaaaa", "aaaaaaaaaaaaa"))
}

fun findAnagrams(s: String, p: String): List<Int> {

    if (p.length > s.length) return listOf()

    val resList = mutableListOf<Int>()
    val k = p.length

    val pmap = mutableMapOf<Char, Int>()
    for (i in 0 until p.length) {
        if (pmap.containsKey(p[i]))
            pmap[p[i]] = pmap[p[i]]!! + 1
        else
            pmap[p[i]] = 1
    }

    val smap = mutableMapOf<Char, Int>()
    for (i in 0 until k) {
        if (smap.containsKey(s[i]))
            smap[s[i]] = smap[s[i]]!! + 1
        else
            smap[s[i]] = 1
    }

    if(pmap == smap) resList.add(0)

    for (i in k until s.length) {
        if (smap.containsKey(s[i]))
            smap[s[i]] = smap[s[i]]!! + 1
        else
            smap[s[i]] = 1

        smap[s[i - k]] = smap[s[i - k]]!! - 1

        if (smap[s[i - k]] == 0)
            smap.remove(s[i - k])


        if (smap == pmap) resList.add(i - k + 1)

    }

    return resList

}