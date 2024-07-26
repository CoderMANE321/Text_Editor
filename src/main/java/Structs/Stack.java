package Structs;

public class Stack {
    static int[] stack = new int[10];
    static int top;
    public Stack() {
        top = -1;
    }

    public void push(int x) {
        stack[++top] = x;
        System.out.println("Pushed " + x + " to the stack");
    }

    public static int pop() {
        if (top < 0) {
            throw new IllegalStateException("Stack is empty");
        }
        System.out.println("Popped element from the stack");
        return stack[top--];
    }

    public static int peek() {
        if (top < 0) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack[top];
    }

}
