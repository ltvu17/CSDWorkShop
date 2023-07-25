
public class BigNumber {

    public static String add(String numStr1, String numStr2) {
        String[] split = numStr1.trim().split(",");
        String[] split1 = numStr2.trim().split(",");
        char[] S1 = split[0].trim().toCharArray();
        char[] S2 = split1[0].trim().toCharArray();
        char[] S3 = {'0'};
        char[] S4 = {'0'};
        if (split.length == 2) {
            S3 = split[1].trim().toCharArray();
        }
        if (split1.length == 2) {
            S4 = split1[1].trim().toCharArray();
        }
        int L1 = S1.length - 1, L3 = S3.length;
        int L2 = S2.length - 1, L4 = S4.length;
        if (L1 < L2) {
            char[] t = S1;
            S1 = S2;
            S2 = t;
            int tt = L1;
            L1 = L2;
            L2 = tt;
        }
        if (L3 < L4) {
            char[] t = S3;
            S3 = S4;
            S4 = t;
            int tt = L3;
            L3 = L4;
            L4 = tt;
        }
        int k = S1.length - 1, u = S3.length - 1;
        int carry = 0, carry1 = 0;
        int j = S2.length - 1, i = S4.length - 1;
        while (i >= 0) {
            int sum = Character.digit(S3[i], 10) + Character.digit(S4[i], 10) + carry1;
            carry1 = sum >= 10 ? 1 : 0;
            if (carry1 > 0) {
                sum -= 10;
            }
            S3[i--] = Character.forDigit(sum, 10);
        }
        if (carry1 > 0) {
            carry = 1;
        }
        while (k >= 0 && j >= 0) {
            int sum = Character.digit(S1[k], 10) + Character.digit(S2[j], 10) + carry;
            carry = sum >= 10 ? 1 : 0;
            if (carry > 0) {
                sum -= 10;
            }
            S1[k] = Character.forDigit(sum, 10);
            j--;
            k--;
        }
        while (k >= 0 & carry == 1) {
            int sum = Character.digit(S1[k], 10) + carry;
            carry = sum >= 10 ? 1 : 0;
            if (carry > 0) {
                sum -= 10;
            }
            S1[k--] = Character.forDigit(sum, 10);
        }

        return carry > 0 ? ("1".concat(new String(S1)) + "," + new String(S3).trim()).trim() : (new String(S1).trim() + "," + new String(S3).trim()).trim();
    }

    public static String shiftLeft(String numStr, int n) {
        if (numStr.equals("0")) {
            return "0";
        }
        String extra = "";
        for (int i = 0; i < n; i++) {
            extra += "0";
        }
        return numStr.trim() + extra.trim();
    }

    public static String multiply(String numStr, char c) {
        if (c == '0') {
            return "0";
        }
        char[] S1 = numStr.trim().toCharArray();
        char[] S = new char[S1.length + 1];
        int carry = 0, result = 0;
        int k = S.length - 1;
        for (int i = k - 1; i >= 0; i--) {
            result = (c - '0') * (S1[i] - '0') + carry;
            carry = result / 10;
            S[k] = Character.forDigit(result % 10, 10);
            k--;
        }
        if (carry > 0) {
            return Character.forDigit(carry, 10) + (new String(S)).trim();
        }
        return (new String(S)).trim();
    }

    public static String multiply(String numStr, String numStr2) {
        int comma = 0, amountS3 = 0, amountS4 = 0;
        String[] split = numStr.trim().split(",");
        String[] split1 = numStr2.trim().split(",");
        char[] S1 = split[0].trim().toCharArray();
        char[] S2 = split1[0].trim().toCharArray();
        char[] S3 = {'0'};
        char[] S4 = {'0'};
        if (split.length == 2) {
            S3 = split[1].toCharArray();
            amountS3 = S3.length;
            numStr = split[0] + split[1];
        }
        if (split1.length == 2) {
            S4 = split1[1].toCharArray();
            amountS4 = S4.length;
            numStr2 = split1[0] + split1[1];
        }
        int L = numStr2.length() - 1;
        String S = "0", multResult, shiftResult;
        for (int i = L; i >= 0; i--) {
            multResult = multiply(numStr, numStr2.charAt(i));
            shiftResult = shiftLeft(multResult, L - i);
            S = add(S, shiftResult);

        }
        comma = amountS3 + amountS4;
        return comma > 0 ? S.substring(0, S.length() - 2 - comma) + "," + S.substring(S.length() - 2 - comma, S.length() - 2) : S;
    }

    public static String sub(String Str1, String Str2) {
        String[] split = Str1.trim().split(",");
        String[] split1 = Str2.trim().split(",");
        char[] S1 = split[0].toCharArray();
        char[] S2 = split1[0].toCharArray();
        char[] S3 = {'0'};
        char[] S4 = {'0'};
        if (split.length == 2) {
            S3 = split[1].trim().toCharArray();
        }
        if (split1.length == 2) {
            S4 = split1[1].trim().toCharArray();
        }
        int L1 = S1.length, L3 = S3.length;
        int L2 = S2.length, L4 = S4.length;
        int sign = 0;
        if (L3 < L4) {
            char[] s = new char[L4];
            for (int i = 0; i < L4; i++) {
                s[i] = '0';
            }
            for (int i = 0; i < L3; i++) {
                s[i] = S3[i];
            }
            S3 = s;
        }
        if (L1 < L2) {
            sign = 1;
            char[] t = S1;
            S1 = S2;
            S2 = t;
            int tt = L1;
            L1 = L2;
            L2 = tt;
            t = S3;
            S3 = S4;
            S4 = t;
            tt = L3;
            L3 = L4;
            L4 = tt;
            if (L3 < L4) {
                char[] s = new char[L4];
                for (int i = 0; i < L4; i++) {
                    s[i] = '0';
                }
                for (int i = 0; i < L3; i++) {
                    s[i] = S3[i];
                }
                S3 = s;
            }
        }
        if (L1 == L2 && split[0].compareTo(split1[0]) < 0) {
            sign = 1;
            char[] t = S1;
            S1 = S2;
            S2 = t;
            int tt = L1;
            L1 = L2;
            L2 = tt;
            t = S3;
            S3 = S4;
            S4 = t;
            tt = L3;
            L3 = L4;
            L4 = tt;
            if (L3 < L4) {
                char[] s = new char[L4];
                for (int i = 0; i < L4; i++) {
                    s[i] = '0';
                }
                for (int i = 0; i < L3; i++) {
                    s[i] = S3[i];
                }
                S3 = s;
                System.out.println(S3);
                System.out.println(S4);
            }
        }
        int k = L1 - 1, u = L3 - 1;
        int carry = 0, carry1 = 0;
        int j = L2 - 1, i = L4 - 1;
        while (i >= 0) {
            S3[i] = Character.forDigit(Character.digit(S3[i], 10) - carry1, 10);
            carry1 = 0;
            int sub = 0;
            if (Character.digit(S3[i], 10) >= Character.digit(S4[i], 10)) {
                sub = Character.digit(S3[i], 10) - Character.digit(S4[i], 10);
            } else {
                sub = Character.digit(S3[i], 10) + 10 - Character.digit(S4[i], 10);
                carry1 = 1;
            }

            S3[i--] = Character.forDigit(sub, 10);
        }
        if (carry1 > 0) {
            carry = 1;
        }

        while (k >= 0 && j >= 0) {
            int sub = 0;

            S1[k] = Character.forDigit(Character.digit(S1[k], 10) - carry, 10);
            if (Character.digit(S1[k], 10) >= Character.digit(S2[j], 10)) {
                sub = Character.digit(S1[k], 10) - Character.digit(S2[j], 10);
                carry = 0;
            } else {
                sub = Character.digit(S1[k], 10) + 10 - Character.digit(S2[j], 10);
                carry = 1;
            }
            S1[k] = Character.forDigit(sub, 10);
            j--;
            k--;
        }

        while (k >= 0 & carry == 1) {
            int sub = 9;
            if (Character.digit(S1[k], 10) == 0 && carry == 1) {
                S1[k] = Character.forDigit(sub, 10);
                carry = 1;
            } else if (carry == 1) {
               sub = Character.digit(S1[k], 10) - carry;
               carry = 0;

            } else {
                sub = Character.digit(S1[k], 10);
                carry = 0;
            }
            S1[k--] = Character.forDigit(sub, 10);
        }

        if (carry == 1) {
            S1[0] = Character.forDigit(Character.digit(S1[0], 10) - carry, 10);

        }


        String beforeCom = new String(S1), afterCom = new String(S3), S;
        int t = 0;
        for (t = 0; t < S1.length; t++) {
            if (Character.digit(S1[t], 10) != 0) {
                beforeCom = beforeCom.substring(t);
                break;
            }
        }
        for (t = S3.length - 1; t > 0; t--) {
            if (Character.digit(S3[t], 10) != 0) {
                afterCom = afterCom.substring(0, t + 1);
                break;
            }
        }

        S = beforeCom + "," + afterCom;
        return sign == 1 ? "-" + S : S;

    }

    public static String input(String Str1, String Str2) {
        if (!Str1.startsWith("+") && !Str1.startsWith("-")) {
            Str1 = "+" + Str1;
        }
        if (!Str2.startsWith("+") && !Str2.startsWith("-")) {
            Str2 = "+" + Str2;
        }
        if ((Str1.startsWith("+") && Str2.startsWith("+"))
                || (Str1.startsWith("-") && Str2.startsWith("-"))) {
            String S = add(Str1.substring(1), Str2.substring(1));
            return Str1.startsWith("-") ? "-" + S : S;
        }
        if ((Str1.startsWith("+") && Str2.startsWith("-"))
                || (Str1.startsWith("-") && Str2.startsWith("+"))) {
            String S = sub(Str1.substring(1), Str2.substring(1));
            return Str1.startsWith("-") ? ((S.startsWith("--")) ? S.substring(2) : S.startsWith("-") ? S.substring(1) : "-" + S) : S;
        }
        return add(Str1.substring(1), Str2.substring(1));
    }

    public static String inputMul(String Str1, String Str2) {
        if (!Str1.startsWith("+") && !Str1.startsWith("-")) {
            Str1 = "+" + Str1;
        }
        if (!Str2.startsWith("+") && !Str2.startsWith("-")) {
            Str2 = "+" + Str2;
        }
        if ((Str1.startsWith("+") && Str2.startsWith("-"))
                || (Str1.startsWith("-") && Str2.startsWith("+"))) {
            return "-" + multiply(Str1.substring(1), Str2.substring(1));
        }
        return multiply(Str1.substring(1), Str2.substring(1));
    }

    public static void main(String[] args) {
        String S7 = "-13565,612126";
        String S5 = "642,52112";
        System.out.format("%50s\n", S7);
        System.out.format("%50s\n", S5);
        String S3 = input(S7, S5);
        String S4 = inputMul(S7, S5);
        System.out.format("Cong: %44s\n", S3);
        System.out.format("Nhan: %50s\n", S4);
    }

}
