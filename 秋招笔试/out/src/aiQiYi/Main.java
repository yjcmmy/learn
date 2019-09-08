package aiQiYi;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] input = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            input[i] = scanner.nextInt();
        }
        int rest = n;
        int count1 = 0;

        long result = 1;
        int flag = input[0];
        for (int i = 0; i < n - 1; i++) {
            if (input[i] == flag) {
                count1++;
            }
            if (input[i] != flag) {

                result *= getResult(count1 + 1, rest) ;
                rest = rest - count1 - 1;
                count1 = 0;
                flag=input[i];

            }
        }


        System.out.println(result);
    }

    public static long getResult(int l, int rest) {
        int a = 1;
        long result = 1;
        rest--;
        for (int i = 1; i < l; i++) {
            result *= rest--;
            a *= i;
        }
        return result / a;
    }
}
