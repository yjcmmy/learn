package Tencent;

import java.util.Scanner;

public class Main {
    static int flag=0;
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
        while(flag==0){
            s = fun(s);
        }
        System.out.println(s);
        
    }
    static String getStr(String s){
        int a=0;
        while(s.charAt(a)!='|'){
             a++;
        }
        int n=Integer.valueOf(s.substring(0,a));
        String result="";
        for(int i=0;i<n;i++){
           result=result+s.substring(a+1);
        }
        return result;
    }

    static String fun(String s){
        int curl=-1;
        int curr=-1;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='['){
                curl=i;
            }
            if(s.charAt(i)==']'){
                curr=i;
                break;
            }
        }
        if(curr==-1){
            flag=1;
            return s;
        }
        String s1 = getStr(s.substring(curl+1,curr));
        s=s.substring(0,curl)+s1+s.substring(curr+1);
        return s;
    }
}
