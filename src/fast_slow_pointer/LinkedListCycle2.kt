package fast_slow_pointer

// link: https://leetcode.com/problems/linked-list-cycle-ii/

fun main() {
    var a = ListNode(3)
    var b = ListNode(2)
    var c = ListNode(0)
    var d = ListNode(-4)

    a.next = b
    b.next = c
    c.next = d
    d.next = b

    println(detectCycle(a)?.value)
}


fun detectCycle(head: ListNode?): ListNode? {
    if (head == null) return null

    var intersect = getIntersect(head)
    if (intersect == null) return null

    var p1 = head
    var p2 = intersect

    while (p1 != p2) {
        p1 = p1?.next
        p2 = p2?.next
    }

    return p1
}

fun getIntersect(head: ListNode?): ListNode? {
    var fast = head
    var slow = head
    while (fast != null) {
        slow = slow?.next
        fast = fast.next?.next

        if (fast != null && fast === slow) return slow
    }
    return null
}
