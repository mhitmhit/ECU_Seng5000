package KW.CH04;

import java.util.Scanner;

public class TestPostfixEvaluator {

    public static void main(String[] args) {

        String line;
        Scanner in = new Scanner(System.in);
        do {

            System.out.println("Enter a postfix expression to evaluate");
            if (in.hasNextLine()) {
                line = in.nextLine();
                try {
                    int result = PostfixEvaluator.eval(line);
                    System.out.println("Value is " + result);
                } catch (PostfixEvaluator.SyntaxErrorException ex) {
                    System.out.println("Syntax error " + ex.getMessage());
                }
            } else {
                break;
            }
        } while (true);
    }
}
