package xiaoHongShu;

import java.util.Scanner;

public class Main {
    static int flag = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String b = "";
        for (int i = 0; i < s.length(); i++) {
            b = b + s.charAt(i);
            if (s.charAt(i) == ')') {
                i++;
                while (i <= s.length() - 1 && s.charAt(i) == '<') {
                    i++;
                }
                i--;
            }

        }
        while (flag != 0) {
            b = getS(b);
        }

        flag = 1;
        while (flag != 0) {
            b = getS2(b);
        }
        while (s!=""&&s.charAt(0) == '<') {
            b=b.substring(1);
        }
        System.out.println(b);

    }

    public static String getS(String s) {
        String b = "";
        int r = 0;
        int l = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                r = i;
            }
            if (s.charAt(i) == ')') {
                l = i;
                break;
            }
            if (i == s.length() - 1 && s.charAt(i) != ')') {
                flag = 0;
                return s;
            }
        }
        b = s.substring(0, r) + s.substring(l + 1);
        return b;
    }

    public static String getS2(String s) {
        String b = "";
        int r = 0;
        int l = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '<') {
                r = i;
            }
            if (s.charAt(i) == '<') {
                l = i;
                break;
            }
            if (i == s.length() - 1 ) {
                flag = 0;
                return s;
            }
        }
        b = s.substring(0, r) + s.substring(l + 1);

        return b;
    }


}
