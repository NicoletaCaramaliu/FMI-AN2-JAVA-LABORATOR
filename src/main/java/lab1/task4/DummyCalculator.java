// task4/DummyCalculator.java
package lab1.task4;

import java.util.Scanner;

public class DummyCalculator {

    public void ruleazaCalculator() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Introduceti expresia (sau 'quit' pentru a iesi): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("quit")) {
                break;
            }

            String[] inputArray = input.split(" ");
            if (inputArray.length < 3) {
                System.out.println("Numar insuficient de argumente. Utilizare: <operand1> <operator> <operand2>");
                continue;
            }

            try {
                String strOperand1 = inputArray[0];
                String operator = inputArray[1];
                String strOperand2 = inputArray[2];

                Object operand1 = parseazaOperand(strOperand1);
                Object operand2 = parseazaOperand(strOperand2);

                Object rezultat = executaOperatie(operand1, operator, operand2);

                System.out.println(rezultat);
            } catch (NumberFormatException e) {
                System.out.println("Format numeric invalid. Introduceți valori numerice valide.");
            } catch (IllegalArgumentException e) {
                System.out.println("Operator invalid. Operatori suportati: +, -, *, /, %, &, |");
            }
        }

        System.out.println("Calculator oprit.");
        scanner.close();
    }

    private Object parseazaOperand(String strOperand) {
        if (strOperand.equalsIgnoreCase("true") || strOperand.equalsIgnoreCase("false")) {
            return Boolean.parseBoolean(strOperand);
        } else if (strOperand.contains(".")) {
            return Double.parseDouble(strOperand);
        } else {
            return Integer.parseInt(strOperand);
        }
    }

    private Object executaOperatie(Object operand1, String operator, Object operand2) {
        if (operand1 instanceof Double || operand2 instanceof Double) {
            double doubleOperand1 = operand1 instanceof Integer ? (double) (int) operand1 : (double) operand1;
            double doubleOperand2 = operand2 instanceof Integer ? (double) (int) operand2 : (double) operand2;

            switch (operator) {
                case "+":
                    return doubleOperand1 + doubleOperand2;
                case "-":
                    return doubleOperand1 - doubleOperand2;
                case "*":
                    return doubleOperand1 * doubleOperand2;
                case "/":
                    if (doubleOperand2 != 0) {
                        return doubleOperand1 / doubleOperand2;
                    } else {
                        throw new ArithmeticException("Impartire la zero!");
                    }
                default:
                    throw new IllegalArgumentException("Operator nesuportat: " + operator);
            }
        } else if (operand1 instanceof Integer && operand2 instanceof Integer) {
            switch (operator) {
                case "+":
                    return (Integer) operand1 + (Integer) operand2;
                case "-":
                    return (Integer) operand1 - (Integer) operand2;
                case "*":
                    return (Integer) operand1 * (Integer) operand2;
                case "/":
                    if ((Integer) operand2 != 0) {
                        return (Integer) operand1 / (Integer) operand2;
                    } else {
                        throw new ArithmeticException("Impartire la zero!");
                    }
                case "%":
                    return (Integer) operand1 % (Integer) operand2;
                default:
                    throw new IllegalArgumentException("Operator nesuportat: " + operator);
            }
        } else if (operand1 instanceof Boolean && operand2 instanceof Boolean) {
            switch (operator) {
                case "&":
                    return (Boolean) operand1 && (Boolean) operand2;
                case "|":
                    return (Boolean) operand1 || (Boolean) operand2;
                default:
                    throw new IllegalArgumentException("Operator nesuportat: " + operator);
            }
        } else {
            throw new IllegalArgumentException("Tipuri de operand incompatibile: " + operand1.getClass() + " si " + operand2.getClass());
        }
    }


}
