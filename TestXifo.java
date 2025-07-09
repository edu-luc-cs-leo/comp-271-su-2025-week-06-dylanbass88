public class TestXifo {

    public static void main(String[] args) {

        // Testing Stack
        Stack stack = new Stack();
        stack.push("apple");
        stack.push("banana");
        stack.push("cherry");
        System.out.println("Stack peek (should be cherry): " + stack.peek());
        System.out.println("Stack pop (should be cherry): " + stack.pop());
        System.out.println("Stack after pop: " + stack.toString());

        // Testing Queue
        Queue queue = new Queue();
        queue.add("dog");
        queue.add("elephant");
        queue.add("frog");
        System.out.println("Queue peek (should be dog): " + queue.peek());
        System.out.println("Queue pop (should be dog): " + queue.pop());
        System.out.println("Queue after pop: " + queue.toString());
    }
}
