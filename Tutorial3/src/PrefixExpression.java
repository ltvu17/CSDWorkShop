
import java.util.Stack;
import java.util.StringTokenizer;

public class PrefixExpression {

    static double evaluatePrefixExp(String exp) {

        double result = 0;
        StringTokenizer stk = new StringTokenizer(exp, "() ");
        Stack<Double> stack = new Stack<Double>();
        Stack<String> reverseString = new Stack<String>();
        while (stk.hasMoreTokens()) {
            String s = stk.nextToken();
            reverseString.push(s);
        }
        while (!reverseString.isEmpty()) {
            String s = reverseString.pop();
            if (!s.equals("+") && !s.equals("-") && !s.equals("*") && !s.equals("/")) {
                stack.push(Double.parseDouble(s));
            } else {
                double n1 = stack.pop();
                double n2 = stack.pop();
                if (s.equals("+")) {
                    result = n1 + n2;
                } else if (s.equals("-")) {
                    result = n1 - n2;
                } else if (s.equals("*")) {
                    result = n1 * n2;
                } else if (s.equals("/")) {
                    if (n2 == 0.0) {
                        throw new RuntimeException("Divided by 0 !");
                    } else {
                        result = n1 / n2;
        
                    }
                } else {
                    throw new RuntimeException("This operation does not supported!");
                }
                stack.push(result);
            }
        }
        return result;
    }
    public static void main(String[] args){
        String exp = "/ 36 * + 1 5 4";
        String exp1 = "* 2 + * 6 5 + * 4 3 * 2 1";
        System.out.println(evaluatePrefixExp(exp1));
    }
}
