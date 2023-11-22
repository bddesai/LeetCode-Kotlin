package sliding_window

// https://leetcode.com/problems/group-anagrams/

fun main() {
    println(groupAnagrams(arrayOf("eat", "tea", "tan", "ate", "nat", "bat")))
    println(groupAnagrams(arrayOf("")))
    println(groupAnagrams(arrayOf("a")))
    println(groupAnagrams(arrayOf("bdddddddddd", "bbbbbbbbbbc")))
}

fun groupAnagrams(strs: Array<String>): List<List<String>> {
    if (strs.isEmpty()) return arrayListOf()

    val map = mutableMapOf<String, MutableList<String>>()
    val count = IntArray(26)

    for (currString in strs) {
        count.fill(0)

        for (c in currString.toCharArray()) count[c - 'a']++

        val sb = StringBuilder("")
        for (i in 0 until 26) {
            sb.append("#") // for input -> [[bdddddddddd], [bbbbbbbbbbc]]
            sb.append(count[i])
        }
        //println(sb)

        val key = sb.toString()
        if (!map.containsKey(key)) map[key] = ArrayList()
        map[key]?.add(currString)
    }

    return map.values.toList()
}

fun groupAnagrams2(strs: Array<String>): List<List<String>> {
    val resultMap = mutableMapOf<String, MutableList<String>>().apply {
        strs.forEach { str ->
            val key = String(str.toCharArray().sortedArray())
            this.getOrPut(key) { mutableListOf() }.add(str)
        }
    }

    val resultList = resultMap.map { it.value }
    return resultList
}