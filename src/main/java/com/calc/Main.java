package com.calc;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();
            if (input.equals("quit")) {
                break;
            }
            Stack<String> expr = splitIntoStack(input);
            int output = StackCalculator.evaluate(expr);
            System.out.println(output);
        }

        scanner.close();
    }

    static Stack<String> splitIntoStack(String str) {
        Stack<String> stack = new Stack<>();
        for (String word : str.split(" ")) {
            stack.push(word);
        }
        return stack;
    }
}
