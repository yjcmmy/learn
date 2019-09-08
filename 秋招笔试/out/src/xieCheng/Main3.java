package xieCheng;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main3 {



    static int schedule(int m,int[] array) {
        int sum[]=new int[array.length];
        sum[0]=array[0];
         for(int i=1;i<array.length;i++){
              sum[i]= array[i]+sum[i-1];
         }
         int max=sum[sum.length-1];
         int average=max/m;
         if(m==1){
             return max;
        }
         while(true){
             int i=0;
             int pre=0;
             int count=m-1;
             while(count!=0){
                 if(sum[i]-sum[pre]>=average){
                     count--;
                     pre=sum[i]-sum[pre]==average?i :i-1;
                 }
                 i++;
             }
             if(sum[sum.length-1]-sum[pre]<=average){
                 break;
             }
             average++;
         }
         return average;
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
