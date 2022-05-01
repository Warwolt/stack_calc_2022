package com.calc;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<String> expr = new Stack<>();

        System.out.print("enter expression: ");
        for (String item : scanner.nextLine().split(" ")) {
            expr.push(item);
        }
        int output = StackCalculator.evaluate(expr);
        System.out.println("output = "+ output);

        scanner.close();
    }
}
