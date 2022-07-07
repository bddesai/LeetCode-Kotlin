package misc

// link: https://leetcode.com/problems/car-fleet/

fun main() {
    println(carFleet(12, intArrayOf(10, 8, 0, 5, 3), intArrayOf(2, 4, 1, 1, 3))) // expected 3
    println(carFleet(10, intArrayOf(6, 8), intArrayOf(3, 2))) // expected 2
    println(carFleet(10, intArrayOf(3), intArrayOf(3))) // expected 1
    println(carFleet(100, intArrayOf(0, 2, 4), intArrayOf(4, 2, 1))) // expected 1
}

fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {

    val etaMap = mutableMapOf<Int, Double>().toSortedMap(reverseOrder())
    for (i in position.indices) {
        etaMap[position[i]] = (target - position[i]) / speed[i].toDouble()
    }

    var fleetCount = 0
    var slowEta = 0.0

    for (currEta in etaMap.values) {
        if (currEta > slowEta) {
            fleetCount++
            slowEta = currEta
        }
    }
    return fleetCount
}

