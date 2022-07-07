package helpers;

public class Stack {

    SinglyLinkedList list;

    public Stack(SinglyLinkedList list){
        this.list = list;
    }

    public void push(Object data){
        list.addLast(data);
    }

    public void pop(){
        list.deleteLast();
    }
}
