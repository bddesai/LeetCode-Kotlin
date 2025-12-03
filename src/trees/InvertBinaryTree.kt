package trees

import kotlin.math.exp
import kotlin.test.assertEquals

fun main() {
    testSimpleThreeNodeTree()
    testComplexTree()
    testLeftSkewedTree()
}

fun invertTree(root: TreeNode?): TreeNode? {
    if (root == null) return null

    // swap
    val tmp = root.left
    root.left = root.right
    root.right = tmp

    // recursive traversal
    invertTree(root.left)
    invertTree(root.right)

    return root
}

fun testSimpleThreeNodeTree() {
    // Input:
    //      2
    //     / \
    //    1   3
    //
    // Expected:
    //      2
    //     / \
    //    3   1

    val input = TreeNode(2)
    input.left = TreeNode(1)
    input.right = TreeNode(3)

    val expected = TreeNode(2)
    expected.left = TreeNode(1)
    expected.right = TreeNode(3)

    val result = invertTree(input)
    //assertEquals(expected, result)
    println("Testing Simple Three Node Tree = " + (expected == result))
}

fun testComplexTree() {
    // Input:
    //      4
    //    /   \
    //   2     7
    //  / \   / \
    // 1   3 6   9
    //
    // Expected:
    //      4
    //    /   \
    //   7     2
    //  / \   / \
    // 9   6 3   1

    val input = TreeNode(4)
    val i2 = input.setLeft(2)
    val i7 = input.setRight(7)
    i2.setLeft(1)
    i2.setRight(3)
    i7.setLeft(6)
    i7.setRight(9)

    val expected = TreeNode(4)
    val e7 = expected.setLeft(7)
    val e2 = expected.setRight(2)
    e7.setLeft(9)
    e7.setRight(6)
    e2.setLeft(3)
    e2.setRight(1)

    val result = invertTree(input)
    //assertEquals(expected, result)
    println("Testing Complex Tree = " + (expected == result))
}

fun testLeftSkewedTree() {
    // Input:
    //      1
    //     /
    //    2
    //   /
    //  3
    //
    // Expected:
    //      1
    //       \
    //        2
    //         \
    //          3

    val input = TreeNode(1)
    input.setLeft(2).setLeft(3)

    val expected = TreeNode(1)
    expected.setRight(2).setRight(3)

    val result = invertTree(input)
    //assertEquals(expected, result)
    println("Testing Left Skewed Tree = " + (expected == result))
}