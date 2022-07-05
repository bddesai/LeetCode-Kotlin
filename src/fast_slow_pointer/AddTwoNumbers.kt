package fast_slow_pointer

// link: https://leetcode.com/problems/add-two-numbers/

fun main() {
    val l1a = ListNode(2)
    val l1b = ListNode(4)
    val l1c = ListNode(3)
    l1a.next = l1b
    l1b.next = l1c

    val l2a = ListNode(5)
    val l2b = ListNode(6)
    val l2c = ListNode(4)
    l2a.next = l2b
    l2b.next = l2c

    var head = addTwoNumbers(l1a, l2a)
    while (head != null) {
        print("${head.value} -> ")
        head = head.next
    }
}

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {

    var c1 = l1
    var c2 = l2

    var c3 = ListNode(0)
    var c3head = c3

    var sum = 0
    var carry = 0
    var rem = 0
    while (c1 != null && c2 != null) {
        sum = c1.value + c2.value + carry
        rem = sum % 10 // c3 node
        carry = sum / 10

        c3.next = ListNode(rem)

        c1 = c1.next
        c2 = c2.next
        c3 = c3.next!!
    }


    while (c1 != null) {
        sum = c1.value + carry
        rem = sum % 10 // c3 node
        carry = sum / 10

        c3.next = ListNode(rem)

        c1 = c1.next
        c3 = c3.next!!
    }

    while (c2 != null) {
        sum = c2.value + carry
        rem = sum % 10 // c3 node
        carry = sum / 10

        c3.next = ListNode(rem)

        c2 = c2.next
        c3 = c3.next!!
    }

    if (carry != 0) {
        c3.next = ListNode(carry)
    }

    return c3head.next
}

/*
fun addTwoNumbers2(l1: ListNode?, l2: ListNode?): ListNode? {
    val c3head = ListNode(0)

    var c1 = l1
    var c2 = l2
    var c3 = c3head

    var carry = 0

    while (c1 != null || c2 != null) {
        val x = if (c1!=null ) c1.value else  0
        val y = if (c2!=null ) c2.value else  0

        val sum = x + y + carry
        carry = sum / 10

        c3.next = ListNode(sum % 10) // remainder
        c3 = c3.next!!

        if (c1 != null) c1 = c1.next
        if (c2 != null) c1 = c2.next
    }

    if (carry > 0) {
        c3.next = ListNode(carry)
    }

    return c3head.next
}
*/

