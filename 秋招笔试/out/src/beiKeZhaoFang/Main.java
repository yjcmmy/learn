package beiKeZhaoFang;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            int n=scanner.nextInt();
            int[] input=new int[n];
            for(int i=0;i<n;i++){
                input[i]=scanner.nextInt();
            }
            int[] record=new int[n];
            record[0]=1;
            for(int i=1;i<n;i++){
                 int cur=1;
                 for(int j=0;j<i;j++){
                     if(input[j]<input[i]){
                         cur=record[j]+1>cur?record[j]+1:cur;
                     }
                 }
                 record[i]=cur;
            }
            int max=0;
            for(int i=0;i<n;i++){
               max=record[i]>max?record[i]:max;
            }
            System.out.print(max);
        }
        scanner.close();

    }
}
