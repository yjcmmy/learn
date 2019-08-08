package pingDuoDuo;

import java.util.*;

public class Main {
    public static int result;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int money = scanner.nextInt();
        int[][] msg=new int[n][3];
        int[] record=new int[n];
        for(int i=0;i<n;i++){
            msg[i][0]=scanner.nextInt();
            msg[i][1]=scanner.nextInt();
            msg[i][2]=scanner.nextInt();

        }
        maxResult(msg,record,money,-1,0,0);
        System.out.println(result);

    }

    static void maxResult(int[][] msg, int[] record,int money, int n,int m,int curResult){
         if(n!=-1){
             if(msg[n][0]*m>money||msg[n][2]<m||record[n]==1){
                 return ;
             }

             record[n]=1;
             curResult+=msg[n][1]*m;
             money-=msg[n][0]*m;
             if(curResult>=result){
                 result=curResult;
             }
         }
        for(int i=0;i<msg.length;i++){
            if(record[i]==0){
                for(int j=1;j<=msg[i][2];j++){
                    maxResult(msg,record,money,i,j,curResult);
                    record[i]=0;
                }
            }

        }
    }


}
