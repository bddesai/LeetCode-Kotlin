package trees

// link: https://leetcode.com/problems/maximum-depth-of-binary-tree/
fun main() {
    val root = TreeNode(3)
    root.left = TreeNode(9)
    root.right = TreeNode(20)
    root.right?.left = TreeNode(15)
    root.right?.right = TreeNode(7)

    val depth = maxDepth(root)
    println("Maximum depth of the binary tree: $depth")
}

fun maxDepth(root: TreeNode?): Int {
    if(root == null) return 0

    val left = maxDepth(root.left)
    val right = maxDepth(root.right)

    return 1 + maxOf(left, right)
}