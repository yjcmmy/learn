package beiKeZhaoFang;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt();
            int[] input=new int[n];
            for(int i=0;i<n;i++){
                 input[i]=scanner.nextInt();
            }
            int matches = 0;
            Arrays.sort(input);
            for (int i=0; i<n;i++){
                System.out.print(input[i]);
            }

            for (int i=0; i<n-1;i++){
                int cur=1;
                 while( i<n-1&&(double)input[i+1]*0.9<=input[i]) {
                     i++;
                     matches+=cur++;
                 }

            }

            System.out.print(matches);

        }

        scanner.close();
    }
}
