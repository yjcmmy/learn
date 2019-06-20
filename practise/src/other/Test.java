package other;

import java.util.*;

public class Test {
    public static void main(String args[]) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('a', 111);
        map.put('a', 22);
        HashSet<Object> objects = new HashSet<>();
        objects.add(1);
        objects.remove(1);
        Iterator iterator = objects.iterator();
        String a = "asdadad   111 asdadad";
        String[] s = a.split(" ");
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }
        List<Integer> b = new ArrayList<>();
        b.add(null);
        b.add(null);
        b.add(null);
        b.add(null);
        Object[][][] map2 = new Object[1][1][2];
        char[] str = {'a', 'c', 'a'};
        HashMap<Character, Integer> strMap = new HashMap<>();
        for (int i = 0; i < str.length; i++) {
            if (strMap.get(str[i]) == null) {
                strMap.put(str[i], 1);
            } else {
                strMap.put(str[i], strMap.get(str[i]) + 1);
            }
        }
        Set<Character> characters = strMap.keySet();
        Integer.parseInt(String.valueOf('1'));
        map2[0][0][0] = 'a';
        map2[0][0][1] = 1;
        System.out.println(b.size());
        System.out.println(map.get('a'));




        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.offer(5);
        System.out.println(queue.poll());
        System.out.println(queue.pollLast());
        System.out.println(queue.pollFirst());

        PriorityQueue<Integer>  priorityQueue=new PriorityQueue<>();
    }
}
