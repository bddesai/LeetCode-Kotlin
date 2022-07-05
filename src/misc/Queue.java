package misc;

public class Queue {

    SinglyLinkedList list;

    public Queue(SinglyLinkedList list){
        this.list = list;
    }

    public void insert(Object data){
        list.addLast(data);
    }

    public void delete(){
        list.deleteFirst();
    }
}
