package jingDong;

import java.util.*;


public class Main {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()) {
            int n=scanner.nextInt();
            int m=scanner.nextInt();

            Map<Integer, Set<Integer>> map = new HashMap<>();
            Set<Integer> set=new HashSet<>();
            for(int i=0;i<m;i++){
                int a=scanner.nextInt();
                int b=scanner.nextInt();
                if(map.get(a)==null){
                    set= new HashSet<Integer>();
                    set.add(b);
                }  else {
                    set = map.get(a) ;
                    set.add(b);
                }
                map.put(a,set);
                if(map.get(b)==null){
                    set= new HashSet<Integer>();
                    set.add(a);
                }  else {
                    set = map.get(b) ;
                    set.add(a);
                }
                map.put(b,set);
            }
            List<Integer> result=new ArrayList<>();
            List<Map.Entry<Integer, Set<Integer>>> list = new ArrayList<>();
            for(Map.Entry<Integer, Set<Integer>> entry:map.entrySet()){
                list.add(entry);
            }
            Collections.sort(list,new MyComparator());
            while(list.get(0).getValue().size()!=0){

                 int cur= list.get(0).getKey();
                result.add(cur);
                 for(Integer i:map.get(cur)){
                     set=map.get(i);
                     set.remove(cur);
                 }
                 map.put(cur,new HashSet<>());
                for(Map.Entry<Integer, Set<Integer>> entry:map.entrySet()){
                    list.add(entry);
                }
                Collections.sort(list,new MyComparator());
            }
            System.out.println(result.size());
            for(int i:result){
                System.out.println(i);
            }
            Collections.sort(list,new MyComparator());
        }
        scanner.close();

    }

}

class MyComparator implements Comparator<Map.Entry<Integer, Set<Integer>>>{
    @Override
    public int compare(Map.Entry<Integer, Set<Integer>> o1, Map.Entry<Integer, Set<Integer>> o2) {
        if(o1.getValue().size()==o2.getValue().size()){
            return o1.getKey()-o2.getKey();
        }
        return o2.getValue().size()-o1.getValue().size();
    }
}