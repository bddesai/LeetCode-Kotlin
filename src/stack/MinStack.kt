package stack

import java.util.*

// 155. Min Stack
// Link: https://leetcode.com/problems/min-stack

fun main(){
    val stack1 = MinStack()
    stack1.push(-2)
    stack1.push(0)
    stack1.push(-3)
    println("Min = " + stack1.getMin())
    stack1.pop()
    println("Top = " + stack1.top())
    println("Min = " + stack1.getMin())
}

class MinStack() {
    private var stack =  Stack<Int>()
    private var minStack = Stack<Int>()

    fun push(`val`: Int) {
        stack.push(`val`)

        // if stack is empty OR given value is less than min value at top of minStack
        if (minStack.isEmpty() || `val` <= minStack.peek()) {
            minStack.push(`val`)
        }
    }

    fun pop() {
        if(stack.isEmpty()) return

        // empty the minStack along with the main stack
        if(stack.pop() == minStack.peek()){
            minStack.pop()
        }
    }

    fun top(): Int {
        if (stack.isEmpty()) throw EmptyStackException()

        return stack.peek()
    }

    fun getMin(): Int {
        if (stack.isEmpty()) println("Stack is Empty")

        return minStack.peek()
    }

}

/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = MinStack()
 * obj.push(`val`)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */