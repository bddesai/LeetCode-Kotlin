package fast_slow_pointer

// link: https://leetcode.com/problems/remove-duplicates-from-sorted-list/

fun main() {
    val a = ListNode(1)
    val b = ListNode(1)
    val c = ListNode(2)
    val d = ListNode(3)
    val e = ListNode(3)

    a.next = b
    b.next = c
    c.next = d
    d.next = e

    var head = deleteDuplicates(a)
    while (head != null) {
        print("${head.value} -> ")
        head = head.next
    }

}

fun deleteDuplicates(head: ListNode?): ListNode? {
    if (head == null) return null

    var curr = head

    while (curr!= null && curr?.next != null) {
        if (curr.value == curr.next?.value) {
            curr.next = curr.next?.next
        } else {
            curr = curr.next
        }
    }

    return head
}