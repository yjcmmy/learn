package ziJieTiaoDong;

import java.util.Scanner;


public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        String a = scanner.nextLine();
        a = scanner.nextLine();
        int[] result = new int[n];
        int[] list = new int[n + k - 1];
        int len=a.length();
        for (int i = 0; i < n + k - 1-len; i++) {
            list[i] = 0;
        }
        for (int i = n + k - 1-len; i < n + k - 1; i++) {
            list[i] = a.charAt(i) - 48;
        }
        result[0] = list[0];
        for (int i = 1; i < n; i++) {
            int cur = list[i];
            if(i<k){
                for (int j = 1; j < k; j++) {
                    if (i - j < 0) {
                        cur ^= 0;
                    } else {
                        cur ^= result[i - j];
                    }
                }
            } else {
                cur=cur^result[i-k]^list[i-1];
            }

            result[i] = cur;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(result[i]);
        }
    }
}
