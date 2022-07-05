package basics

fun main() {

    println(countConstruct("abcdef", arrayOf("ab", "abc", "cd", "def", "abcd"), mutableMapOf()))

    println(countConstruct("skateboard", arrayOf("bo", "rd", "ate", "t", "ska", "sk", "boar"), mutableMapOf()))

    println(countConstruct("enterapotentpot", arrayOf("a", "p", "ent", "enter", "ot", "o", "t"), mutableMapOf()))

    println(
        countConstruct(
            "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
            arrayOf("e", "ee", "eee", "eeee", "eeeee", "eeeeee", "eeeeeee"),
            mutableMapOf()
        )
    )

}


fun countConstruct(target: String, wordBank: Array<String>, memo: MutableMap<String, Int>): Int {

    if (memo.containsKey(target)) return memo[target]!!

    if (target == "")
        return 1

    var totalCount = 0

    for (word in wordBank) {
        if (target.indexOf(word) == 0) {
            val suffix = target.removePrefix(word)
            val numWaysForRest = countConstruct(suffix, wordBank, memo)
            totalCount += numWaysForRest
        }
    }

    memo[target] = totalCount
    return totalCount
}


// memoized
// time = O(n * m^2)
// space = O(m^2)
