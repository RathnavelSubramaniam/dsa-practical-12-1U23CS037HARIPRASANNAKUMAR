import java.util.*;

public class linkedStack {
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node top;

    linkedStack() {
        this.top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }
        int poppedData = top.data;
        top = top.next;
        return poppedData;
    }

    public void displayStack() {
        Node current = top;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        linkedStack stack = new linkedStack();
        Scanner scanner = new Scanner(System.in);
        int ch, data;

        System.out.println("ENTER INTEGERS TO CREATE NODES (ENTER A NON-INTEGER TO EXIT):");
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                data = scanner.nextInt();
                stack.push(data);
            } else {
                scanner.next(); // Consume non-integer input
                System.out.println("STACK USING LINKED LIST HAS BEEN CREATED");
                stack.displayStack();
                break;
            }
        }

        do {
            System.out.println("1.PUSH");
            System.out.println("2.POP");
            System.out.println("3.DISPLAY");
            System.out.println("4.EXIT");
            System.out.println("ENTER YOUR CHOICE:");
            ch = scanner.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("ENTER THE ELEMENT TO PUSH INTO STACK:");
                    data = scanner.nextInt();
                    stack.push(data);
                    System.out.println("STACK ELEMENTS AFTER PUSH OPERATION ARE:");
                    stack.displayStack();
                    break;
                case 2:
                    data = stack.pop();
                    if (data != -1) {
                        System.out.println("POPPED ELEMENT IS: " + data);
                        System.out.println("STACK ELEMENTS AFTER POP:");
                        stack.displayStack();
                    }
                    break;
                case 3:
                    System.out.println("STACK ELEMENTS:");
                    stack.displayStack();
                    break;
                case 4:
                    System.out.println("EXITING PROGRAM.");
                    break;
                default:
                    System.out.println("INVALID CHOICE! TRY AGAIN.");
            }
        } while (ch != 4);

        scanner.close();
    }
}