package xinDong;

import com.sun.xml.internal.bind.v2.runtime.reflect.Accessor;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] input=new int[n];
        for(int i=0;i<n;i++){
             input[i]=scanner.nextInt();
        }
        List<List<Integer>> list = new ArrayList<>();
        while(scanner.hasNext()){
            List<Integer> son=new ArrayList<>();
            son.add(scanner.nextInt());
            son.add(scanner.nextInt());
            list.add(son);
        }
        int a[]=new int[n];
        for(List<Integer> son:list){
            a[son.get(0)]++;
            a[son.get(1)]++;
        }

        Arrays.sort(input);
        int result=0;
        for(int i=1;i<n;i++){
            result+=input[i] ;
        }
        for(int i=0;i< n;i++){
            if(a[i]==3&&a[i]==input[0]){
                int min=Integer.MAX_VALUE;
                for(List<Integer> son:list){
                    if(son.get(0)==input[0]){
                        min=Math.min(min,son.get(1));
                    }
                    if(son.get(1)==input[0]){
                        min=Math.min(min,son.get(0));
                    }
                }
                result=result+input[0] -min;
            }
        }

        System.out.println(result);

    }

}

