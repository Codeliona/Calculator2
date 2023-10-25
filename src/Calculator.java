import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) throws Exception {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите уравнение: ");
            String expression = scanner.nextLine();

            int num1;
            int num2;
            String oper;
            String result;
            boolean isRoman;

            String[] operands = expression.split("[+\\-*/]");
                if (operands.length != 2) throw new Exception("Ошибка! Должно быть два операнда (2 числа: римские или арабские)");
                    oper = new Calculator().detectOperation(expression);
                if (oper == null) throw new Exception("Ошибка! Неподдерживаемая математическая операция");
                if (Roman.isRoman(operands[0]) && Roman.isRoman(operands[1])) {
                    num1 = Roman.convertToArabian(operands[0]);
                    num2 = Roman.convertToArabian(operands[1]);
                    isRoman = true;
                } else if (!Roman.isRoman(operands[0]) && !Roman.isRoman(operands[1])) {
                    num1 = Integer.parseInt(operands[0]);
                    num2 = Integer.parseInt(operands[1]);
                    isRoman = false;
                } else {
                    throw new Exception("Ошибка! Числа должны быть в одном формате: либо римские, либо арабские");
                } if (num1 > 10 || num2 > 10) {
                    throw new Exception("Ошибка! Числа должны быть от 1 до 10 / I - X");
                }
        int arabian = switch (oper) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            default -> num1 / num2;
        };
        if (isRoman) {
            if (arabian <= 0) {
                throw new Exception("Ошибка! Римское число должно быть больше нуля");
            }
            result = Roman.convertToRoman(arabian);
        } else {
            result = String.valueOf(arabian);
        }
        System.out.println(result);
        }

    public String detectOperation(String expression) {
            if (expression.contains("+")) {
                return "+";
            } else if (expression.contains("-")) {
                return "-";
            } else if (expression.contains("*")) {
                return "*";
            } else if (expression.contains("/")) {
                return "/";
            } else return null;
        }

}
