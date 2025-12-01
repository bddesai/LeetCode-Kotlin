package arrays


fun main() {
    // Example usage
    val myArray = intArrayOf(5, 6, 2, 4, 3, 1)
    val sortedArray = alternatingSort(myArray)

    // Print the result
    println(sortedArray)
}

fun alternatingSort(arr: IntArray): List<Int> {
    // 1. Create a mutable copy of the array and sort it in ascending order.
    val sortedArr = arr.sorted().toMutableList()

    val result = mutableListOf<Int>()
    var left = 0
    var right = sortedArr.size - 1

    while (left <= right) {
        if (left == right) {
            // Handle the middle element in odd-length arrays (it will always be the largest remaining)
            result.add(sortedArr[right])
        } else {
            // Append the largest remaining element (from the right)
            result.add(sortedArr[right])

            // Append the smallest remaining element (from the left)
            result.add(sortedArr[left])
        }

        // Move pointers inward
        right -= 1
        left += 1
    }

    return result
}


