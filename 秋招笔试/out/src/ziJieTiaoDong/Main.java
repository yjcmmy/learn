package ziJieTiaoDong;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            int n=scanner.nextInt();
            int[] list=new int[n];
            for(int i=0;i<n;i++){
                 list[i]=getTime(scanner.nextInt(),scanner.nextInt());
            }
            int time=scanner.nextInt();
            int lastTime=getTime(scanner.nextInt(),scanner.nextInt())-time;
            if(lastTime<0){
                lastTime=lastTime+24*60;
            }
            int max=0;
            for(int i=0;i<n;i++){
                 max=list[i]<=lastTime?Math.max(list[i],max):max;
            }
            
            System.out.print(max/60+" "+max%60);
        }
        scanner.close();


    }
    static int getTime(int a,int b){
        return a*60+b;
    }
}
