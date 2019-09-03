package xinDong;

import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String s=scanner.nextLine();
            int n=Integer.valueOf(scanner.nextLine());
            List<String> list=new ArrayList<>();

            for(int i=0;i<n;i++){
                list.add(scanner.nextLine());
            }
            Map<Character,Integer> map = new HashMap<>();
            int count=0;
            for(int i=0;i<s.length();i++){
                count++;
                 map.put(s.charAt(i),count) ;
            }
            MyComparator myComparator=new MyComparator(map);
            Collections.sort(list,myComparator);
            for(String s1:list){
                System.out.println(s1);
            }

        }

        scanner.close();
    }

//    public static int mySort(String s,Map<Character,Integer> map ){
//        int result=0;
//        int len=1000;
//        for(int i=0;i<s.length() ;i++) {
//            result += map.get(s.charAt(i)) * len;
//            len--;
//        }
//        return  result;
//    }
}
class MyComparator implements Comparator<String>{
    Map<Character,Integer> map =new HashMap<>();
    MyComparator(Map<Character,Integer> map){
          this.map=map;
    }
    @Override
    public int compare(String o1, String o2) {
        int i=0;
         while(i<o1.length()&&i<o2.length()&&o1.charAt(i)==o2.charAt(i)){
             i++;
         }
         if(i==o1.length()||i==o2.length()){
             return o1.length()-o2.length();
         } else {
             return map.get(o1.charAt(i))-map.get(o2.charAt(i));
         }


    }


}
