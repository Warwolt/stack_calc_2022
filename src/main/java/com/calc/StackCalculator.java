package com.calc;

public class StackCalculator {
    public static int evaluate(Stack<String> input) {
        Stack<String> operators = new Stack<>();
        Stack<Integer> operands = new Stack<>();

        while (!input.isEmpty()) {
            String elem = input.pop().get();

            if (elem.equals("+")) {
                operators.push(elem);
            } else {
                operands.push(Integer.parseInt(elem));
            }

            if (!operators.isEmpty()) {
                String operator = operators.pop().get();
                if (operator.equals("+")) {
                    if (operands.size() < 2) {
                        throw new IllegalArgumentException(String.format("Missing right operand to addition operator"));
                    }
                    int rhs = operands.pop().get();
                    int lhs = operands.pop().get();
                    operands.push(lhs + rhs);
                }
            }
        }

        return operands.isEmpty() ? 0 : operands.pop().get();
    }
}
