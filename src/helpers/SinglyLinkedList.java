package helpers;

public class SinglyLinkedList {
    Node head;

    public SinglyLinkedList(){
        head = new Node(null);
    }

    public void addFirst(Object data){
        Node first_node = new Node(data);
        if (head.data == null) {
            head = first_node;
        } else {
            first_node.next = head;
            head = first_node;
        }
    }

    public void addLast(Object data) {
        Node new_node = new Node(data);
        new_node.next = null;

        if (head.data == null) {
            head = new_node;
        } else {
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }

            last.next = new_node;
        }
    }

    public void deleteLast(){
        Node current = this.head;

        while (current.next.next != null) {
            current = current.next;
        }

        current.next.data = null;
        current.next = null;
    }

    public void deleteFirst(){
        Node current = head;

        head = head.next;

        current.data = null;
        current.next = null;
    }

    public void printList() {
        Node current = this.head;

        while (current.next != null) {
            System.out.print(current.data + ", ");
            current = current.next;
        }

        System.out.println(current.data);
    }

    public int size(){
        Node current = this.head;
        int counter = 0;
        while (current.next != null) {
            counter++;
            current = current.next;
        }

        return counter;
    }

}
