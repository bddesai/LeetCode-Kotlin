package basics

fun main() {

    println(canConstruct("abcdef", arrayOf("ab", "abc", "cd", "def", "abcd"), mutableMapOf()))

    println(canConstruct("skateboard", arrayOf("bo", "rd", "ate", "t", "ska", "sk", "boar"), mutableMapOf()))

    println(canConstruct("enterapotentpot", arrayOf("a", "p", "ent", "enter", "ot", "o", "t"), mutableMapOf()))

    println(
        canConstruct(
            "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
            arrayOf("e", "ee", "eee", "eeee", "eeeee", "eeeeee", "eeeeeee"),
            mutableMapOf()
        )
    )

}


fun canConstruct(target: String, wordBank: Array<String>, memo: MutableMap<String, Boolean>): Boolean {

    if (memo.containsKey(target)) return memo[target]!!

    if (target == "")
        return true

    for (word in wordBank) {
        if (target.indexOf(word) == 0) {
            val suffix = target.removePrefix(word)
            if (canConstruct(suffix, wordBank, memo)) {
                memo[target] = true
                return true
            }
        }
    }

    memo[target] = false
    return false
}

// brute force
// time = O(n^m  *  m)  // branching factor raise to height of tree multiplied by slicing factor
// space = O(m^2)   // suffix and word bank


//fun canConstructTabulation(target: String, wordBank: Array<String>){
//    val table = CharArray(target + 1){0 }
//}