package pingDuoDuo;

import com.sun.javafx.image.BytePixelSetter;

import java.util.*;

public class Solution1 {
    static  boolean flag= false;
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        String s = scanner.nextLine();
        String[] s1 = s.split(" ");
        for(int i=0;i<s1.length;i++){
            swap(s1,0,i);
            find(s1,0);
            if(flag==true){
                break;
            }
            swap(s1,0,i);
        }

        System.out.println(flag);
    }

    

    static boolean judge(String s1,String s2){
        if(s1.charAt(s1.length()-1)==s2.charAt(0)){
            return  true;
        }
        return false;
    }

    static void swap(String[] s,int i,int j){
        String a=s[i];
        s[i]=s[j];
        s[j]=a;
    }

    static void find(String[] s, int k){
          if(k==s.length&&judge(s[k-1],s[0])){
              flag=true;
              return;
          }

          for(int i=k;i<s.length;i++){
              if(k>0&&judge(s[k-1],s[i])){
                  swap(s,k,i);
                  find(s,k+1);
                  swap(s,k,i);
              } else if(k==0){
                  swap(s,k,i);
                  find(s,k+1);
                  swap(s,k,i);
              }
          }
    }

}
