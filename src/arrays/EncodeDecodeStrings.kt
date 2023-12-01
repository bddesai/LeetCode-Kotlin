package arrays

fun main() {
    val list = listOf("lint", "code", "love", "you")

    val encodedStr = encode(list)
    println("Encoded String = $encodedStr")

    val decodedStringsList = decode(encodedStr)
    println("Decoded String = $decodedStringsList")
}

fun encode(strs: List<String>): String {
    var res = ""
    strs.forEach { str ->
        res += str.length.toString() + "#" + str
    }
    return res
}


fun decode(str: String): List<String> {
    val res = mutableListOf<String>()
    var i = 0

    while (i < str.length) {
        var j = i
        while (str[j] != '#') {
            j++
        }
        val length = str.substring(i, j).toInt()
        res.add(
            str.substring(j + 1, j + 1 + length)
        )
        i = j + 1 + length
    }

    return res
}