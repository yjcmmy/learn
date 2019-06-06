package other;

import java.util.*;

public class Test {
    public static void main(String args[]){
        HashMap<Character,Integer> map =new HashMap<>();
        map.put('a',111);
        map.put('a',22);
        HashSet<Object> objects = new HashSet<>();
        objects.add(1);
        objects.remove(1);
        Iterator iterator=objects.iterator();
        System.out.println(map.get('a'));
    }
}
