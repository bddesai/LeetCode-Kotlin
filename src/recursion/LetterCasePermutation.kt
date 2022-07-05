fun main(args: Array<String>) {
    print(letterCasePermutation("a1b2"))
}

fun letterCasePermutation(s: String): List<String> {
    val result: ArrayList<String> = arrayListOf()
    helper(result, StringBuilder(),  s, 0)
    return result
}

fun helper(result: ArrayList<String>, partial: StringBuilder, s: String, i: Int) {
    if (s.length == partial.length) {
        result.add(partial.toString())
        return
    }

    if (partial.length > s.length) return

    if (s[i].isDigit()) {
        partial.append(s[i])
        helper(result, partial, s, i + 1)
        partial.deleteCharAt(partial.length - 1)
    } else {
        partial.append(s[i].toUpperCase())
        helper(result, partial, s, i + 1)
        partial.deleteCharAt(partial.length - 1)

        partial.append(s[i].toLowerCase())
        helper(result, partial, s, i + 1)
        partial.deleteCharAt(partial.length - 1)
    }

}
