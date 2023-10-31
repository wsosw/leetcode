package exam;

import java.util.Scanner;
import java.util.Stack;

public class Exam360 {


    // 360编程题目二
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int formulaCount = in.nextInt();
        in.nextLine();

        String[] formulas = new String[formulaCount];
        for (int i = 0; i < formulaCount; i++) {
            formulas[i] = in.nextLine();
        }

        for (String formula : formulas) {

            Stack<Character> stack1 = new Stack<>();
            Stack<Character> stack2 = new Stack<>();

            String[] split = formula.split("=");

            int leftValue = getFormulaValue(split[0]);

            int rightValue = getFormulaValue(split[1]);

            if (leftValue == rightValue) {
                System.out.println("Yes");
            } else {


            }

        }

    }

    public static int getFormulaValue(String str) {

        int value = 0;
        boolean dop = false;

        Stack<String> stack = new Stack<>();

        Stack<String> numberStack = new Stack<>();
        Stack<Character> operationStack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (Character.isDigit(ch)) {
                if (numberStack.isEmpty() || numberStack.peek().equals("operator") ) numberStack.push(String.valueOf(ch));
                else numberStack.push(numberStack.pop() + ch);
            } else {

                if (dop) {
                    int v1 = Integer.parseInt(numberStack.pop());
                    numberStack.pop();
                    int v2 = Integer.parseInt(numberStack.pop());

                    char op = operationStack.pop();
                    if (op == '+') numberStack.push(String.valueOf(v1+v2));
                    if (op == '-') numberStack.push(String.valueOf(v1-v2));
                    if (op == '*') numberStack.push(String.valueOf(v1*v2));
                }

                numberStack.push("operator");
                operationStack.push(ch);
                dop = operationStack.size() > 1 && operationStack.peek() == '*';
            }

        }


        return 0;
    }


    // 360编程题目一
//    public static void main(String[] args) {
//
//        Scanner in = new Scanner(System.in);
//
//        int T = in.nextInt();
//        in.nextLine();
//
//        for (int i = 0; i < T; i++) {
//
//            int staffCount = in.nextInt();
//            int powerValue = in.nextInt();
//            in.nextLine();
//
//
//        }
//
//
//
//
//
//
//    }



}
