package wanMei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        String s = scanner.nextLine();
        String[] s1 = s.split(" ");
        int w=Integer.valueOf(scanner.nextLine());

        Map<Integer,Integer> map = new HashMap<>();
        int len=0;
        int count=0;
        for(int i=0;i<s1.length;i++){
            int cur=Integer.valueOf(s1[i]);
            if(map.get(cur)==null){
                map.put(cur,1);
            }else {
                map.put(cur,map.get(cur)+1);
            }
        }

        int l=1;
        int r=w;
        while(l<=r){

            if(map.get(l)==null||map.get(l)==0){
                l++;
                continue;
            }
            if(map.get(r)==null||map.get(r)==0){
                r--;
                continue;
            }
            int a=map.get(l);
            int b=map.get(r);
            if(l==r){
                count+=a;
                break;
            }
            if(l+r<=w){

                 if(a<=b){
                     count+=a;
                     l++;
                     map.put(r,b-a);
                 }else{
                     count+=b;
                     r--;
                     map.put(l,a-b);
                 }
            } else {
                count+=map.get(r);
                r--;
            }

        }
        System.out.print(count);
    }
}
