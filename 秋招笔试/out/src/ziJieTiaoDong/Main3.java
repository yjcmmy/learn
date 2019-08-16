package ziJieTiaoDong;

import javax.swing.plaf.basic.BasicSplitPaneUI;
import java.util.Iterator;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            int n=scanner.nextInt();
            int[] input=new int[n];
            for(int i=0;i<n;i++){
                input[i]=scanner.nextInt();
            }
            int[] left=new int[n];
            left[0]=100;
            for(int i=1;i<n;i++){
               if(input[i]>input[i-1]){
                   left[i]=left[i-1]+100;
               } else {
                   left[i]=100;
               }
            }
            int[] right=new int[n];
            right[n-1]=100;
            for(int i=n-2;i>=0;i--){
                if(input[i]>input[i+1]){
                    right[i]=right[i+1]+100;
                }else {
                    right[i]=100;
                }
            }
            int result=0;
            for(int i=0;i<n;i++){
                 result+=Math.max(right[i],left[i]) ;
            }
            System.out.println(result);

        }
        scanner.close();


    }
}
