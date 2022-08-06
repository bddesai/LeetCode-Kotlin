package recursion

// link: https://leetcode.com/problems/powx-n/

fun main() {
    println(myPow(2.0, 10))
    println(myPow(2.0, -2))
    println(myPow(2.0, -10))
}

// Recursion
fun myPow(x: Double, n: Int): Double {
    var N: Long = n.toLong()
    var X=x
    if (N < 0) {
        X = 1 / X
        N = -N;
    }
    return myPowHelper(X, N);
}

fun myPowHelper(x: Double, n: Long): Double {
    if (n == 0L) {
        return 1.0
    }

    var half: Double = myPowHelper(x, n / 2)

    when {
        n == 0L -> return 1.0
        n % 2 == 0L -> return half * half
        else -> return x * half * half
    }
}
