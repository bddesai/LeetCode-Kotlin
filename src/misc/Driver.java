class Driver {

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        list.addLast(1);
        list.addLast(2);
        list.addLast("Bhavin");
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);

        // list.deleteLast();
        // list.deleteFirst();

        // Queue
        Queue queue = new Queue(list);
        queue.insert(7);
        for (int i = 0; i < 3; i++) {
            queue.delete();
        }

        // Stack
        Stack stack = new Stack(list);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        stack.pop();
        stack.pop();

        // print
        list.printList();
        System.out.println("\nsize = " + list.size());
    }
}