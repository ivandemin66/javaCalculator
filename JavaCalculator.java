import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter the first number: ");
            double operand1 = scanner.nextDouble();

            char operation;
            while (true) {
                System.out.print("Choose operation (+, -, *, /): ");
                operation = scanner.next().charAt(0);
                if (operation == '+' || operation == '-' || operation == '*' || operation == '/') {
                    break;
                } else {
                    closeErrorOperand();
                } 
            }

            System.out.print("Enter the second number: ");
            double operand2 = scanner.nextDouble();

            double result = performOperation(operand1, operation, operand2);
            System.out.println("Your result: " + Math.round(result * 10.0) / 10.0);

            System.out.println("Do you want to continue the calculations? y/n (c to reset, e to exit)");
            String answer = scanner.next();
            if ("e".equalsIgnoreCase(answer)) {
                break;
            } else if ("c".equalsIgnoreCase(answer)) {
                continue;
            } else if (!"y".equalsIgnoreCase(answer)) {
                break;
            }
        }
        scanner.close(); 
    }

    private static void closeErrorOperand() {
        System.out.println("Error: Invalid operand. Try again.");
    }

    private static double performOperation(double operand1, char operation, double operand2) {
        double result = 0;
        switch (operation) {
            case '+':
                result = operand1 + operand2;
                break;
            case '-':
                result = operand1 - operand2;
                break;
            case '*':
                result = operand1 * operand2;
                break;
            case '/':
                if (operand2 != 0) {
                    result = operand1 / operand2;
                } else {
                    System.err.println("Division by zero is not allowed!");
                    return 0; 
                }
                break;
            default:
                System.err.println("Unknown operation!");
                return 0; 
        }
        return result;
    }
}