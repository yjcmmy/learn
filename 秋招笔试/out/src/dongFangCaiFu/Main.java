package dongFangCaiFu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        int[] day=new int[n];
        for(int i=0;i<n-1;i++){
          day[i]=scanner.nextInt();
        }
        int max=0;
        for(int i=0;i<=n-1;i++){
             int cur=max(day,0,i)+max(day,i+1,n-1);
             max=cur>max?cur:max;
        }
        System.out.println(max);
    }
    static int max(int[] day,int m,int n){
        if(m-n==0){
            return 0;
        }
        int max=0;
        int min=Integer.MAX_VALUE;
        for(int i=m;i<=n;i++){
          min=day[i]< min?day[i]:min;
          max=day[i]-min>max? day[i]-min:max;
        }
        return max;
    }
}
