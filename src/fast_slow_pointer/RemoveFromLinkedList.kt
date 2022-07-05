package fast_slow_pointer

// link: https://leetcode.com/problems/remove-linked-list-elements/

fun main(){
    val a = ListNode(1)
    val b = ListNode(2)
    val c = ListNode(6)
    val d = ListNode(3)
    val e = ListNode(4)
    val f = ListNode(5)
    val g = ListNode(6)
    a.next = b
    b.next = c
    c.next = d
    d.next = e
    e.next = f
    f.next = g
    var value = 6

//    val a = ListNode(7)
//    val b = ListNode(7)
//    val c = ListNode(7)
//    val d = ListNode(8)
//    a.next = b
//    b.next = c
//    c.next = d
//    var value = 7


    var head = removeElements(a, value)
    while (head != null) {
        print("${head.value} -> ")
        head = head.next
    }
}

fun removeElements(head: ListNode?, value: Int): ListNode? {
    if (head == null) return null

    val sentinel  = ListNode(0)
    sentinel.next = head

    var prev = sentinel
    var curr = head

    while (curr != null) {
        if (value == curr.value) {
            prev.next = curr.next
        } else {
            prev = curr
        }
        curr = curr.next
    }
    return sentinel.next
}
