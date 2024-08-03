package Structs;


public class Stack {
    static String[] stack = {};
    static int top = 0;

    public Stack(int capacity) {
        stack = new String[capacity];
        top = -1;
    }

    public void push(String file) {
        /*if (isFull()){
            System.out.println("Stack is full");
        }*/
        if (isFull()) {
            System.out.println("Stack is full");
            return;
        }

        if (isEmpty()) {
            stack[++top] = file;
        } else {
            stack[++top] = file;
        }
        System.out.println("Pushed " + file + " to the stack");
    }

    public static String pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        System.out.println("Popped element from the stack");
        return stack[top--];
    }

    public static String peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack[top];
    }

    public static boolean isEmpty() {
        return top == -1;
    }

    /*public static boolean isFull() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return false;
        }
        return stack[top] == stack[stack.length - 1];
    }*/

    public static boolean isFull() {
        return top == stack.length - 1;
    }
}
