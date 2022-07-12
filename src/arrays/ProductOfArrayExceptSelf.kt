package arrays


// link: https://leetcode.com/problems/product-of-array-except-self/submissions/

fun main() {
    productExceptSelf(intArrayOf(1, 2, 3, 4)).forEach {
        print("$it ")
    }
     println(productExceptSelf(intArrayOf(-1, 1, 0, -3, 3)))
}

fun productExceptSelf(nums: IntArray): IntArray {
    val len = nums.size

    // The left and right arrays as described in the algorithm
    val L = IntArray(len)
    val R = IntArray(len)

    // Final answer array to be returned
    val answer = IntArray(len)

    // L[i] contains the product of all the elements to the left
    // Note: for the element at index '0', there are no elements to the left,
    // so L[0] would be 1
    L[0] = 1
    for (i in 1 until len) {

        // L[i - 1] already contains the product of elements to the left of 'i - 1'
        // Simply multiplying it with nums[i - 1] would give the product of all
        // elements to the left of index 'i'
        L[i] = nums[i - 1] * L[i - 1]
    }

    // R[i] contains the product of all the elements to the right
    // Note: for the element at index 'length - 1', there are no elements to the right,
    // so the R[length - 1] would be 1
    R[len - 1] = 1
    for (i in len - 2 downTo 0) {

        // R[i + 1] already contains the product of elements to the right of 'i + 1'
        // Simply multiplying it with nums[i + 1] would give the product of all
        // elements to the right of index 'i'
        R[i] = nums[i + 1] * R[i + 1]
    }

    // Constructing the answer array
    for (i in 0 until len) {
        // For the first element, R[i] would be product except self
        // For the last element of the array, product except self would be L[i]
        // Else, multiple product of all elements to the left and to the right
        answer[i] = L[i] * R[i]
    }

    return answer
}
