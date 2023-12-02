package two_pointer

// 42. Trapping Rain Water
// Link: https://leetcode.com/problems/trapping-rain-water/
fun main() {
    val height1 = intArrayOf(0,1,0,2,1,0,1,3,2,1,2,1)
    println(trap(height1))

    val height2 = intArrayOf(4, 2, 0, 3, 2, 5)
    println(trap(height2))
}

fun trap(height: IntArray): Int {
    var (l, r) = 0 to height.size - 1
    var (leftMax, rightMax) = height[l] to height[r]
    var res = 0

    while (l < r) {
        if (leftMax < rightMax) {
            l++
            leftMax = maxOf(leftMax, height[l])
            res += leftMax - height[l]
        } else {
            r--
            rightMax = maxOf(rightMax, height[r])
            res += rightMax - height[r]
        }
    }

    return res
}
