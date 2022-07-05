package fast_slow_pointer

// link: https://leetcode.com/problems/linked-list-cycle/

fun hasCycle(head: ListNode?): Boolean {
    var fast = head
    var slow = head

    while(fast != null){
        slow = slow?.next
        fast = fast?.next?.next

        if(fast!= null && fast === slow) return true
    }

    return false
}