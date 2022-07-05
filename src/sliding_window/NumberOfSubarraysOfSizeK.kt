package sliding_window

// link: https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/

fun main() {

    var arr = intArrayOf(2, 2, 2, 2, 5, 5, 5, 8)
    val k = 3
    val threshold = 4

    println(numOfSubarrays(arr, k, threshold))
}


fun numOfSubarrays(arr: IntArray, k: Int, threshold: Int): Int {

    //var windowSum = arr.slice(0 until k).sum()
    var windowSum = 0
    for (i in 0 until k) windowSum += arr[i]

    var numOfSubarrays: Int = if (windowSum >= threshold * k) 1 else 0

    for (i in k until arr.size) {
        windowSum += arr[i] - arr[i - k]

        if (windowSum >= threshold * k) {
            numOfSubarrays++
        }
    }

    return numOfSubarrays
}
// O(n)


fun numOfSubarraysBruteForce(arr: IntArray, k: Int, threshold: Int): Int {

    var l = 0
    var r = l + k - 1

    var numOfSubarrays = 0

    while (r < arr.size) {

        var sum = 0
        for (i in l until r + 1) {
            sum += arr[i]
        }
        if (sum / k >= threshold) {
            numOfSubarrays++
        }

        l++
        r++
    }

    return numOfSubarrays
}
// O(n^k)
