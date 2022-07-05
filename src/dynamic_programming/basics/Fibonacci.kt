package basics

fun main() {
    println(fibTabulation1(21))
    println(fibTabulation2(21))
}

// tabulation
fun fibTabulation1(n: Int): Int {
    if (n == 0 || n == 1) return n

    val table = IntArray(n + 1)

    table[0] = 0
    table[1] = 1

    for (i in 2 until n + 1) {
        table[i] = table[i - 1] + table[i - 2]
    }

    return table[n]
}

// time = O(n)
// space = O(n)


fun fibTabulation2(n: Int): Int {
    val table = IntArray(n+2) { 0 }

    table[1] = 1

    for(i in 0 until n){
        table[i+1] += table[i]

        table[i+2] += table[i]
    }
    return table[n]
}