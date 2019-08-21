package Tencent;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=scanner.nextInt();
        }
        int[] result=new int[n];
        for(int i=0;i<n;i++){
            result[i]=getl(a,i)+1+getr(a,i);
            System.out.print(result[i]+" ");
        }


    }
    static int getr(int[] a,int b){
        int max=0;
        int count=0;
        for(int i=b+1;i<a.length;i++){
            if(a[i]>max){
                count++;
                max=a[i];
            }
        }
        return count;
    }
    static int getl(int[] a,int b){
        int max=0;
        int count=0;
        for(int i=b-1;i>=0;i--){
            if(a[i]>max){
                count++;
                max=a[i];
            }
        }
        return count;
    }
}
