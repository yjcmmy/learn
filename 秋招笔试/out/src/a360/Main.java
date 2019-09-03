package a360;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n =scanner.nextInt();
        int[] input=new int[n];
        for(int i=0;i<n;i++){
            input[i]=scanner.nextInt();
        }
        System.out.println(getMax(n,input));
    }

    public static int getMax(int n, int[] input) {
        int max = 0;
        //i是边数
        for(int i=n;i>=3;i--){
            //这个是判断i条边是否能构成正i边形
            if(n%i!=0){
                continue;
            }
            //a是边数为i时共有a种情况
            int a=n/i;
            for(int j=0;j<a;j++){
                int curMax=0;
                for(int k=0;k<i;k++){
                     curMax+= input[a*k+j];
                }
                max=Math.max(curMax,max);
            }
        }

        return  max;
    }


}
