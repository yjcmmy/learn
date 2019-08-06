package dongFangCaiFu;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        String s = scanner.nextLine();
        String[] s1 = s.split(" ");
        String a=s1[0];
        String b=s1[1];
        String c=s1[2];
       boolean result=result(a,b,c,0,0,0);
       if(result){
           System.out.println("TRUE");
       }else {
           System.out.println("FALSE");
       }



    }
    static boolean result(String a,String b,String c,int i,int j,int n){
        if(i==a.length()&&j==b.length()){
            return true;
        }
        boolean result1=false;
        boolean result2=false;
        if(i<=a.length()-1&&a.charAt(i)==c.charAt(n)){
            result1=result(a,b,c,i+1,j,n+1);
        }
        if(j<=b.length()-1&&b.charAt(j)==c.charAt(n)){
            result2=result(a,b,c,i,j+1,n+1);
        }
        return result1||result2;
    }

}
