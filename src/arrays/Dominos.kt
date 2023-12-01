package arrays

import kotlin.test.assertEquals


/* Given a list of Dominos where each domino is of type [x, y]
*  Find a pair of dominos [x, y] and [p, q] such that
*  x + p = N and y + q = N
* */

fun main() {
    val list = listOf(
        Pair(1, 5),
        Pair(2, 4),
        Pair(5, 1),
        Pair(4, 2),
        Pair(7, 11)
    )
    val N = 6

    println(findPair(list, N))
    assertEquals(true, findPair(list, N))
}


fun findPair(dominos: List<Pair<Int, Int>>, N: Int): Boolean {

    val set = hashSetOf<Pair<Int, Int>>()

    dominos.forEach { domino ->
        if (set.contains(domino)) return true

        val complementX = N - domino.first
        val complementY = N - domino.second

        set.add(Pair(complementX, complementY))
    }

    return false
}