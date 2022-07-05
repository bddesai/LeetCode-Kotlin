package cycle_sort


// link : https://leetcode.com/problems/missing-number/

fun main() {
    val array: IntArray = intArrayOf(5, 1, 0, 3, 2)
    print("Missing number ${missingNumber(array)}\n")

    val array2: IntArray = intArrayOf(9,6,4,2,3,5,7,0,1)
    print("Missing number ${missingNumber(array2)}\n")
}

fun missingNumber(arr: IntArray): Int {
    var i = 0
    // sort array in place using cycle sort
    while (i < arr.size) {
        var correct = arr[i]
        if (arr[i] < arr.size && arr[i] != arr[correct]) {
            swap(arr, i, correct)
        } else {
            i++
        }
    }

    // find missing number
    for (j in 0..arr.size) {
        if (arr[j] != j) {
            return j
        }
    }

    return arr.size
}

