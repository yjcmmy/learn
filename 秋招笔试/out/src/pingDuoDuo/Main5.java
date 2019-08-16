package pingDuoDuo;

import java.util.Scanner;

public class Main5 {

    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            int n=scanner.nextInt();
            int s=scanner.nextInt();
            int[][] a=new int[2][s+1];
            for(int i=1;i<s+1;i++){
                a[0][i]=1;
                if(i>=3){
                  a[1][i]=(i-1)/2;
                }
            }
            for(int i=3;i<=n;i++){
                 int cur1=i%2;
                 int cur2=(i-1)%2;
                 for(int j=1;j<s+1;j++){
                     a[cur2][j]=0;
                     int q=j;
                     if(j-n>0){
                         a[cur2][j]+=a[cur1][j-n];
                     }
                     while(q-n>0){
                         a[cur2][j]+=a[cur2][q-n];
                         q=q-n;
                     }
                 }
            }
            System.out.print(a[(n-1)%2][s]);

        }
        scanner.close();

        
    }

//    static void getCount(int[] list,int n,int target){
//         if(n==list.length-1){
//             if(target>list[n-1]){
//                 count++;
//                 count=count%1000000007;
//                 return;
//             } else {
//                 return;
//             }
//
//         }
//         for(int i=n==0?1:list[n-1]+1;i<=target/(list.length-n);i++){
//             list[n]=i;
//             target=target-i;
//             getCount(list,n+1,target);
//             target=target+i;
//
//         }
//
//    }
}
