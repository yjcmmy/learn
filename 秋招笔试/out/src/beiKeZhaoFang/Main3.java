package beiKeZhaoFang;
import java.util.Arrays;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt();
            int[] input=new int[n];
            for(int i=0;i<n;i++){
                input[i]=scanner.nextInt();
            }

            int[][] left=new int[n][2];
            int[][] right=new int[n][2];
            for(int i=0;i<n;i++){
                left[i][1]=input[i];
                right[i][1]=input[i];
            }
            left[0][0]=0;
            right[n-1][0]=0;
            for(int i=1;i<n;i++){
                if(left[i][1]<=left[i-1][1]){

                    left[i][0]= left[i-1][1]-left[i][1]+1+left[i-1][0];
                    left[i][1]=left[i-1][1]+1;
                }else {
                    left[i][0]=left[i-1][0];
                }
                System.out.println(left[i][0]+" "+left[i][1]);

            }
            for(int i=n-2;i>=0;i--){
                if(right[i][1]<=right[i+1][1]){

                    right[i][0]=right[i+1][1]-right[i][1]+1+right[i+1][0];
                    right[i][1]=right[i+1][1]+1;
                } else {
                    right[i][0]=right[i+1][0];
                }
                System.out.println(right[i][0]+" "+right[i][1]);
            }
            int min=Integer.MAX_VALUE;
            for(int i=1;i<n;i++) {
                  min=Math.min(min,right[i][1]!=left[i-1][1]?right[i][0]+left[i-1][0]:right[i][0]+left[i-1][0]+1) ;
            }
            System.out.print(min);
        }

        scanner.close();
    }
}