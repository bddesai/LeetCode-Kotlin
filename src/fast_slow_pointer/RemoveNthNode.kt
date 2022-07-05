package fast_slow_pointer

// link: https://leetcode.com/problems/remove-nth-node-from-end-of-list/submissions/

fun main() {
    val a = ListNode(1)
    val b = ListNode(2)
    val c = ListNode(3)
    val d = ListNode(4)
    val e = ListNode(5)
    a.next = b
    b.next = c
    c.next = d
    d.next = e

    val n = 3

    var head = removeNthFromEnd(a, n)
    while (head != null) {
        print("${head.value} -> ")
        head = head.next
    }
}

fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    var fast = head
    var slow = head

    for (i in 0 until n) {
        fast = fast?.next
    }

    if (fast == null) return head?.next

    while (fast?.next != null) {
        slow = slow?.next
        fast = fast.next
    }

    slow?.next = slow?.next?.next
    return head
}
