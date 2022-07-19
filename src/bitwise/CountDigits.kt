package bitwise

fun main() {
    println("1234 -> Num of Digits = ${countDigitsRecursive(1234)}")
}

// time = O(n)
// space = O(1)
fun countDigits(num: Int): Int {
    var count = 0
    var numVal = num
    while (numVal > 0) {
        numVal /= 10
        count++
    }
    return count
}

fun countDigitsRecursive(n: Int): Int {
    // base case
    if (n == 0) return 0

    // recursion
    return 1 + countDigits(n / 10)
}