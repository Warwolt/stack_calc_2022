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

            // integrate the stack calculator here

            System.out.println(input);
        }

        scanner.close();
    }
}
