package xieCheng;

import java.util.*;

public class Test {

    static int sum(int s,int e,int[] a){
        int sum=0;
        for(int b=s-1;b<=(e-1);b++){
            sum+=a[b];
        }
        return sum;
    }

    static int schedule(int m,int[] array) {
        int n=array.length;
        int[][] dp=new int[m+1][n+1];

        for(int i=1;i<=n;i++){
            int s=0;
            for(int x=1;x<=i;x++){
                s+=array[x-1];
            }
            dp[1][i]=s;
        }
        for(int m1=2;m1<=m;m1++){
            for(int n1=1;n1<=n;n1++){
                dp[m1][n1]=Integer.MAX_VALUE;
                int max=-1;

                for(int i=1;i<=n1;i++){
                    max=Math.max(dp[m1-1][i-1],sum(i,n1,array));
                    dp[m1][n1]=Math.min(dp[m1][n1],max);
                }
            }
        }
        return   dp[m][n];
    }

    
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int size  = in.nextInt();
        int[] array = new int[size];
        for(int i = 0; i < size; i++) {
            array[i] = in.nextInt();
        }
        int res = schedule(m,array);
        System.out.println(String.valueOf(res));
    }

   

}