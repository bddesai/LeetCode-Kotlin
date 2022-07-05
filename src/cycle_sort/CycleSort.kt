package cycle_sort

import java.util.*

fun main() {
    val array: IntArray = intArrayOf(3,5,2,1,4)
    cycleSort(array)
    print(Arrays.toString(array))
}

fun cycleSort(arr: IntArray) {
    var i = 0
    while (i < arr.size) {
        val correctIndex = arr[i] - 1

        if (arr[i] != arr[correctIndex]) {
            swap(arr, i, correctIndex)
        } else {
            i++
        }
    }
}

fun swap(arr: IntArray, i: Int, j: Int) {
    val temp = arr[i]
    arr[i] = arr[j]
    arr[j] = temp
}
