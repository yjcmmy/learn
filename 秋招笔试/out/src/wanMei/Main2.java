package wanMei;

import java.util.Scanner;

public class Main2 {
    static  int[] result=new int[6];
    public static void main(String[] args){
        for(int i=0;i<6;i++){
            result[i]=Integer.MAX_VALUE;
        }
        Scanner scanner=new Scanner(System.in);
        int[][] a=new int[6][6];
        for(int i=0;i<6;i++){
            for(int j=0;j<6;j++){
               a[i][j]=scanner.nextInt();
            }

        }
        int[][] path=new int[6][6];
        for(int i=1;i<6;i++){
            find(path,a,i,0,0);
            System.out.println(result[i]);
        }
    }

    static void find(int[][] path,int[][] a,int tar,int cur,int sum){
        if(cur==tar){
           result[tar]=Math.min(result[tar],sum);
           return;
        }
        for(int i=1;i<6;i++) {
            if(path[cur][i]==1||a[cur][i]==-1){
                continue;
            }
            path[cur][i]=1;
            find(path,a,tar,i,sum+a[cur][i]);
            path[cur][i]=0;
        }
    }
}
