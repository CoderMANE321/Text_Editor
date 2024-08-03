import Structs.Stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StackTests {

    private Stack stack;

    @BeforeEach
    public void setUp() {
        stack = new Stack(10);
    }

    @Test
    public void testPush() {
        stack.push("text");
        assertEquals(1, stack.peek(), "Top element should be 1 after pushing 1");
    }

    @Test
    public void testPop() {
        stack.push("text");
        String poppedValue = stack.pop();
        assertEquals(2, poppedValue, "Popped value should be 2");
    }

    @Test
    public void testPeek() {
        stack.push("text");
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
        stack.push("test");
        assertFalse(stack.isEmpty(), "Stack should not be empty after pushing an element");
    }

    @Test
    public void testFullStack() {
        String test = "text";
        for (int i = 0; i < 4; i++) {
            char letter = test.charAt(i);
            stack.push(String.valueOf(letter));
        }
        assertTrue(stack.isFull(), "Stack should be full after pushing 10 elements");
        try {
            stack.push("text");
            fail("Expected an IllegalStateException to be thrown");
        } catch (IllegalStateException e) {
            assertEquals("Stack is full", e.getMessage());
        }
    }
}
