package a360;


import java.util.*;

public class Main {

    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            int n=scanner.nextInt();
            int m=scanner.nextInt();
            LinkedList<Integer> a = new LinkedList<>();
            LinkedList<Integer> b = new LinkedList<>();
            for(int i=0;i<n;i++){
               a.add(scanner.nextInt());
            }
            for(int i=0;i<n;i++){
                b.add(scanner.nextInt());
            }
            Collections.sort(a);
            Collections.sort(b);
            int[] result=new int[n];
            int count=0;
            int cur=1;
            while(a.size()>0){
                int q = find(a, b, m - cur)+find(a,b,2*m-cur);
                for(int i=0;i<q;i++){
                     result[count+i]=m-cur;
                }
                count+=q;
                cur++;
            }
            for(int i=0;i<n;i++){
                System.out.print(result[i]+" ");
            }
        }
        scanner.close();
    }

    static int find(List<Integer> a,List<Integer> b,int target){
        int len=a.size();
        int left=0;
        int right=len-1;
        int count=0;
        
        while(left<len&&right>=0){
            int cur=a.get(left)+b.get(right);
            if(cur==target){
               count++;
               a.set(left,-1);
               b.set(right,-1);
               left++;
               right--;
            }else{
                if(cur>target){
                    right--;
                } else {
                    left++;
                }
            }
        }
        remove(a);
        remove(b);
        return count;
    }
    static void remove(List<Integer> a) {
         for(int i=0;i<a.size();i++){
             if(a.get(i)==-1){
                 a.remove(i);
                 i--;
             }
         }
    }
}
