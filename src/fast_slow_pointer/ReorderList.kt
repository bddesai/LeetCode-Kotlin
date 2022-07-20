package fast_slow_pointer

// https://leetcode.com/problems/reorder-list/

fun main() {
    val a = ListNode(1)
    val b = ListNode(2)
    val c = ListNode(3)
    val d = ListNode(4)
    val e = ListNode(5)
//    val f = ListNode(6)

    a.next = b
    b.next = c
    c.next = d
    d.next = e
//    e.next = f

    reorderList(a)

    printLinkedList(a)
}

fun printLinkedList(head: ListNode?){
    var curr = head
    while (curr != null) {
        print("${curr.value} -> ")
        curr = curr.next
    }
}

fun reorderList(head: ListNode?): Unit {
    var slow = head
    var fast = head
    while (fast?.next != null) {
        slow = slow!!.next
        fast = fast.next!!.next
    }

    // Reverse the list
    var prev: ListNode? = null
    var curr = slow
    var tmp: ListNode?
    while (curr != null) {
        tmp = curr.next
        curr.next = prev
        prev = curr
        curr = tmp
    }


    // Merge the lists
    var first = head
    var second = prev!!
    while (second.next != null) {
        tmp = first?.next
        first?.next = second
        first = tmp

        tmp = second.next
        second.next = first
        second = tmp!!
    }

    return
}

