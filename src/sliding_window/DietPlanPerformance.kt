package sliding_window


// link: https://leetcode.com/problems/diet-plan-performance/

fun main() {

//    println(dietPlanPerformance(intArrayOf(1, 2, 3, 4, 5), 1, 3, 3))
    println(dietPlanPerformance1(intArrayOf(3, 2), 2, 0, 1))
    println(dietPlanPerformance1(intArrayOf(6, 5, 0, 0), 2, 1, 5))
}

fun dietPlanPerformance(calories: IntArray, k: Int, lower: Int, upper: Int): Int {
    // initialization
    var windowSum = 0
    for (i in 0 until k) windowSum += calories[i]

    var points = when {
        windowSum > upper -> 1
        windowSum < lower -> -1
        else -> 0
    }

    for (i in k until calories.size) {
        windowSum += calories[i] - calories[i - k]
        when {
            windowSum > upper -> points++
            windowSum < lower -> points--
        }
    }

    return points
}

fun dietPlanPerformance1(calories: IntArray, k: Int, lower: Int, upper: Int): Int {
    var windowSum = 0
    var points = 0

    for (i in 0 until calories.size) {
        windowSum += calories[i]

        if (i < k - 1) continue

        if (i >= k) windowSum -= calories[i - k]

        when{
            windowSum > upper -> points++
            windowSum < lower -> points--
        }
    }

    return points
}

