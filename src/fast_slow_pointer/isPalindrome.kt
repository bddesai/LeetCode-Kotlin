package fast_slow_pointer

// link: https://leetcode.com/problems/palindrome-linked-list

fun main() {
    val a = ListNode(1)
    val b = ListNode(2)
    val c = ListNode(3)
    val d = ListNode(4)
    val e = ListNode(1)

    a.next = b
    b.next = c
    c.next = d
    d.next = e


    println(isPalindrome(a))
}

fun isPalindrome(head: ListNode?): Boolean {
    val firstHalfEnd = findFirstHalfEnd(head)
    val secondHalfStart = reverseList(firstHalfEnd?.next)

    var p1 = head
    var p2 = secondHalfStart;
    var result = true
    while (result && p2 != null) {
        if (p1?.value != p2.value)
            result = false

        p1 = p1?.next
        p2 = p2.next
    }

    firstHalfEnd?.next = reverseList(secondHalfStart)

    return result
}

fun isPalindrome2(head: ListNode?): Boolean {
    if (head == null) return true

    var fast: ListNode? = head
    var slow: ListNode? = head

    while (fast!!.next != null && fast.next!!.next != null) {
        fast = fast.next!!.next
        slow = slow!!.next
    }

    var firsthead: ListNode? = reverseList(slow!!.next)
    var secondhead: ListNode? = head

    while (firsthead != null && secondhead != null) {
        if (firsthead.value != secondhead.value) return false
        firsthead = firsthead.next
        secondhead = secondhead.next
    }

    return true
}

fun reverseList(head: ListNode?): ListNode? {
    var curr = head
    var prev: ListNode? = null
    var tmpNext: ListNode? = null

    while (curr != null) {
        tmpNext = curr.next
        prev = curr.next
        prev = curr
        curr = tmpNext
    }
    return prev
}

fun findFirstHalfEnd(head: ListNode?): ListNode? {
    var fast = head
    var slow = head
    var count = 0

    while (fast != null) {
        fast = fast.next
        count++
        if (count == 2) {
            slow = slow?.next
            count = 0
        }
    }

    return slow
}
