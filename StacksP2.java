class StacksP2 {
    private class Node {
        int data;
        Node prev, next;
        
        Node(int data) {
            this.data = data;
        }
    }
    
    private Node head, mid;
    private int size;
    
    public StacksP2() {
        head = mid = null;
        size = 0;
    }

    public void push(int x) {
        Node newNode = new Node(x);
        newNode.next = head;
        
        if (head != null) {
            head.prev = newNode;
        }
        
        head = newNode;
        size++;

        if (size == 1) {
            mid = head;
        } else if (size % 2 != 0) { 
            mid = mid.prev;
        }
    }

    public int pop() {
        if (head == null) {
            throw new IllegalStateException("Stack is empty");
        }
        
        int val = head.data;
        head = head.next;
        size--;

        if (head != null) {
            head.prev = null;
        }

        if (size % 2 == 0 && mid != null) {
            mid = mid.next;
        }

        if (size == 0) {
            mid = null;
        }

        return val;
    }

    public int getMid() {
        if (mid == null) {
            throw new IllegalStateException("Stack is empty");
        }
        return mid.data;
    }

    public int popMid() {
        if (mid == null) {
            throw new IllegalStateException("Stack is empty");
        }
        
        int val = mid.data;

        if (mid.prev != null) {
            mid.prev.next = mid.next;
        }
        if (mid.next != null) {
            mid.next.prev = mid.prev;
        }

        if (size % 2 == 0) {
            mid = mid.next;
        } else {
            mid = mid.prev;
        }

        size--;
        
        if (size == 0) {
            head = mid = null;
        }

        return val;
    }

    public void printStack() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StacksP2 stack = new StacksP2();
        
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        
        stack.printStack();
        System.out.println("Mid: " + stack.getMid());
        
        System.out.println("Pop Mid: " + stack.popMid());
        stack.printStack(); 

        System.out.println("Pop: " + stack.pop());
        stack.printStack(); 
    }
}
