package basics

fun main() {

//    println(gridTraveller(1, 1, mutableMapOf()))
//    println(gridTraveller(2, 3, mutableMapOf()))
//    println(gridTraveller(3, 2, mutableMapOf()))
//    println(gridTraveller(3, 3, mutableMapOf()))
//    println(gridTraveller(18, 18, mutableMapOf()))


    println(gridTravellerTabulation(1, 1))
    println(gridTravellerTabulation(2, 3))
    println(gridTravellerTabulation(3, 2))
    println(gridTravellerTabulation(3, 3))

}

fun gridTraveller(m: Long, n: Long, memo: MutableMap<String, Long>): Long {
    // return precalculated values
    val key = "$m,$n"
    if (memo.containsKey(key)) return memo[key]!!

    // base case
    if (m == 1L && n == 1L) return 1
    if (m == 0L || n == 0L) return 0

    // memoize
    memo[key] = gridTraveller(m - 1, n, memo) + gridTraveller(m, n - 1, memo)
    return memo[key]!!
}
// time = O(m+n)
// space = O(m+n)


fun gridTravellerTabulation(m: Int, n: Int): Int {
    val table = Array(m + 1) { IntArray(n + 1) }
    table[1][1] = 1

    for (i in 0..m) { // <= m
        for (j in 0..n) { // <= n

            val current = table[i][j]

            if (j + 1 <= n)
                table[i][j + 1] += current
            if (i + 1 <= m)
                table[i + 1][j] += current
        }
    }

    return table[m][n]
}

fun printTable(table: Array<IntArray>){
    table.forEach { it1 ->
        it1.forEach { it2 -> print("$it2 ") }
        print("\n")
    }

}
