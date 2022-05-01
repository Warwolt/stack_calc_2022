package com.calc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Stack<T> {
    private ArrayList<T> items;

    public Stack() {
        items = new ArrayList<>();
    }

    public static <T> Stack<T> fromList(List<T> list) {
        Stack<T> stack = new Stack<>();
        for (T elem : list) {
            stack.items.add(elem);
        }
        return stack;
    }

    public void push(T item) {
        items.add(item);
    }

    public Optional<T> peek() {
        if (items.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(items.get(items.size() - 1));
        }
    }

    public Optional<T> pop() {
        Optional<T> item = peek();
        if (item.isPresent()) {
            items.remove(items.size() - 1);
        }
        return item;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public int size() {
        return items.size();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("[");
        for (int i = 0; i < items.size(); i++) {
            str.append(items.get(i));
            if (i < items.size() - 1) {
                str.append(", ");
            }
        }
        str.append("]");
        return str.toString();
    }
}
