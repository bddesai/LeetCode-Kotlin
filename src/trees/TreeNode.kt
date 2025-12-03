package trees

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    // Helper to add nodes easily for setup
    fun setLeft(value: Int): TreeNode {
        this.left = TreeNode(value)
        return this.left!!
    }

    fun setRight(value: Int): TreeNode {
        this.right = TreeNode(value)
        return this.right!!
    }

    // Override equals to allow structural comparison (value matching)
    // instead of reference comparison (memory address matching).
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as TreeNode

        if (`val` != other.`val`) return false
        if (left != other.left) return false
        if (right != other.right) return false

        return true
    }

    override fun hashCode(): Int {
        var result = `val`
        result = 31 * result + (left?.hashCode() ?: 0)
        result = 31 * result + (right?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String {
        return "TreeNode($`val`)"
    }
}
