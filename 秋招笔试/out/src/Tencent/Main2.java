package Tencent;

import java.util.*;

public class Main2 {
    static int count=0;
    static int cur=0;
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();

        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            List<Integer> son=new ArrayList<>();
            son.add(scanner.nextInt());
            son.add(scanner.nextInt());
            list.add(son);
        }
        Collections.sort(list,new Mycomparatot());
        int max=findMax(list,0);

        while(max<m){
            int result=findMax(list,max);
            if(max==result){
                System.out.println("-1");
                return;
            }
            max=result;
        }

        System.out.println(count);

    }

    static int findMax(List<List<Integer>> list,int r){
        int max=r;
        for(int i=cur;i<list.size();i++){
            List<Integer> son=list.get(i);
            if(son.get(0)>r){
                break;
            }
            if(son.get(1)>=max){
                max= son.get(1);
                cur=i+1;
            }

        }
        count++;
        return max;
    }

}
class Mycomparatot implements Comparator<List<Integer>>{
    @Override
    public int compare(List<Integer> o1, List<Integer> o2) {
        return o1.get(0)-o2.get(0);
    }
}
