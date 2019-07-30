package pingDuoDuo;

import javax.xml.transform.Result;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        String[] a1 = s1.split(" ");
        int[] a=new int[a1.length];
        for(int i=0;i<a1.length;i++){
            a[i]=Integer.valueOf(a1[i]);
        }
        String[] b1=s2.split(" ");
        int[] b=new int[b1.length];
        for(int i=0;i<b1.length;i++){
            b[i]=Integer.valueOf(b1[i]);
        }

        if(a.length==1){
            System.out.print(a[0]+" ");
            return;
        }
        int result=Integer.MIN_VALUE;
        for(int i=1;i<a.length;i++){
            if(a[i]<=a[i-1]){
                if(i!=a.length-1){
                    result = find(b, a[i - 1], a[i + 1]);
                }  else{
                    result=find(b,a[i-1],Integer.MAX_VALUE);
                }
                if(result==Integer.MIN_VALUE&&a[i]==a[i-1]){
                    if(i-2<0){
                        result=find(b,Integer.MIN_VALUE,a[i]);
                    } else {
                        result=find(b,a[i-2],a[i]);
                    }
                    i--;
                }

                if(result==Integer.MIN_VALUE){
                    System.out.println("NO");
                    break;
                } else {
                    a[i]=result;
                    for(int j=0;j<a.length;j++){
                        System.out.print(a[j]+" ");
                    }
                    break;
                }
            }

        }
    }

    static int find(int[] b, int l, int r){
        int max=Integer.MIN_VALUE;
        for(int i=b.length-1;i>=0;i--){
            if(l<b[i]&&b[i]<r){
                max=max>b[i]?max:b[i];
            }
        }
         return  max;
    }


}
