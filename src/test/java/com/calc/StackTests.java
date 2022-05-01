package com.calc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Optional;

public class StackTests {
    @Test
    void newStackIsEmpty() {
        Stack<Integer> stack = new Stack<>();
        assertTrue(stack.isEmpty());
    }

    @Test
    void pushingOntoStack_MakesItNonEmpty() {
        Stack<Integer> stack = new Stack<>();

        stack.push(2);

        assertFalse(stack.isEmpty());
    }

    @Test
    void poppingEmptyStack_GivesNothing() {
        Stack<Integer> stack = new Stack<>();

        Optional<Integer> item = stack.pop();

        assertEquals(Optional.empty(), item);
    }

    @Test
    void poppingPushedItem_GivesBackThatItem() {
        Stack<Integer> stack = new Stack<>();
        Integer expected = 123;

        stack.push(expected);
        Optional<Integer> item = stack.pop();

        assertEquals(Optional.of(expected), item);
    }

    @Test
    void pushedItems_ArePoppedInReverseOrder() {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(Optional.of(3), stack.pop());
        assertEquals(Optional.of(2), stack.pop());
        assertEquals(Optional.of(1), stack.pop());
    }

    @Test
    void peekingEmptyStack_GivesBackNothing() {
        Stack<Integer> stack = new Stack<>();
        assertEquals(Optional.empty(), stack.peek());
    }

    @Test
    void peekingItem_ReturnsLastPushedItem() {
        Stack<Integer> stack = new Stack<>();

        stack.push(11);
        stack.push(22);

        assertEquals(Optional.of(22), stack.peek());
    }

    @Test
    void peekingItem_DoesNotRemove() {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.peek();

        assertFalse(stack.isEmpty());
    }

    @Test
    void stackCanBeCreatedFromList() {
        Stack<Integer> stack = Stack.fromList(Arrays.asList(1, 2, 3));
        assertEquals(Optional.of(3), stack.pop());
        assertEquals(Optional.of(2), stack.pop());
        assertEquals(Optional.of(1), stack.pop());
    }

    @Test
    void stackSizeEqualsNumberOfPushedItems() {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, stack.size());
    }
}
