package cycle_sort

// link: https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

fun main() {
    // range [0..N]
    println(
        findAllNumbersMissingInArray(intArrayOf(4, 3, 0, 7, 8, 2, 1))
    )

    // range [1..N]
    println(
        findDisappearedNumbers(intArrayOf(4,3,2,7,8,2,3,1)).toString()
    )
}

fun findAllNumbersMissingInArray(arr: IntArray): List<Int> {

    // cycle sort
    for (i in 0..arr.size) {
        var correct = arr[i]
        if (arr[i] != arr[correct]) {
            swap(arr, i, correct)
        }
    }

    val list = ArrayList<Int>()

    for (j in 0..arr.size) {
        if (arr[j] != j)
            list.add(j)
    }
    return list
}

fun findDisappearedNumbers(arr: IntArray): List<Int> {
    // cycle sort
    var i = 0
    while (i < arr.size) { // 0 .. n-1
        val correct = arr[i] - 1
        if (arr[i] != arr[correct])
            swap(arr, i, correct)
        else
            i++
    }

    // find missing numbers
    val list = ArrayList<Int>()
    // for (j in 0 until arr.size){
    for (j in arr.indices) { // 0 .. n-1
        if (arr[j] != j + 1) {
            list.add(j + 1)
        }
    }
    return list
}