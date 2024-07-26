import Structs.Stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StackTests {

    private Stack stack;

    @BeforeEach
    public void setUp() {
        stack = new Stack();
    }

    @Test
    public void testPush() {
        stack.push(1);
        assertEquals(1, stack.peek(), "Top element should be 1 after pushing 1");
    }

    @Test
    public void testPop() {
        stack.push(2);
        int poppedValue = stack.pop();
        assertEquals(2, poppedValue, "Popped value should be 2");
    }

    @Test
    public void testPeek() {
        stack.push(3);
        assertEquals(3, stack.peek(), "Top element should be 3 after pushing 3");
    }

    @Test
    public void testPopEmptyStack() {
        try {
            stack.pop();
            fail("Expected an IllegalStateException to be thrown");
        } catch (IllegalStateException e) {
            assertEquals("Stack is empty", e.getMessage());
        }
    }

    @Test
    public void testPeekEmptyStack() {
        try {
            stack.peek();
            fail("Expected an IllegalStateException to be thrown");
        } catch (IllegalStateException e) {
            assertEquals("Stack is empty", e.getMessage());
        }
    }

    @Test
    public void testEmptyStack() {
        assertTrue(stack.isEmpty(), "Stack should be empty initially");
        stack.push(1);
        assertFalse(stack.isEmpty(), "Stack should not be empty after pushing an element");
    }

    @Test
    public void testFullStack() {
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        assertTrue(stack.isFull(), "Stack should be full after pushing 10 elements");
        try {
            stack.push(11);
            fail("Expected an IllegalStateException to be thrown");
        } catch (IllegalStateException e) {
            assertEquals("Stack is full", e.getMessage());
        }
    }
}
