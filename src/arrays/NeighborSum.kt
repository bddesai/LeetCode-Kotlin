package arrays

fun main() {
    println(neighborSum(intArrayOf(1, 2, 3, 4)).contentToString())
}

fun neighborSum(a: IntArray): IntArray {
    val n = a.size
    if (n == 0) return IntArray(0)
    val res = IntArray(n)

    for (i in 0 until n) {
        val left = i - 1
        val right = i + 1

        val sum = when {
            left < 0 -> a[i] + a[right]
            right > n - 1 -> a[i] + a[left]
            else -> a[left] + a[right] + a[i]
        }
        res[i] = sum
    }
    return res
}

fun neighborSum2(a: IntArray): IntArray {
    val n = a.size
    if (n == 0) return IntArray(0)
    val res = IntArray(n)

    for (i in 0 until n) {
        val left = if (i > 0) a[i - 1] else 0
        val right = if (i < n - 1) a[i + 1] else 0
        res[i] = left + a[i] + right
    }
    return res
}
