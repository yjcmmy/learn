package other;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;


public class Test {
    public static void main(String args[]) {
        System.out.println(numTrees(4));


//        HashMap<Character, Integer> map = new HashMap<>();
//        map.put('a', 111);
//        map.put('a', 22);
//        HashSet<Object> objects = new HashSet<>();
//        objects.add(1);
//        objects.remove(1);
//        Iterator iterator = objects.iterator();
//        String a = "asdadad   111 asdadad";
//        String[] s = a.split(" ");
//        for (int i = 0; i < s.length; i++) {
//            System.out.println(s[i]);
//        }
//        List<Integer> b = new ArrayList<>();
//        b.add(null);
//        b.add(null);
//        b.add(null);
//        b.add(null);
//        Object[][][] map2 = new Object[1][1][2];
//        char[] str = {'a', 'c', 'a'};
//        HashMap<Character, Integer> strMap = new HashMap<>();
//        for (int i = 0; i < str.length; i++) {
//            if (strMap.get(str[i]) == null) {
//                strMap.put(str[i], 1);
//            } else {
//                strMap.put(str[i], strMap.get(str[i]) + 1);
//            }
//        }
//        Set<Character> characters = strMap.keySet();
//        Integer.parseInt(String.valueOf('1'));
//        map2[0][0][0] = 'a';
//        map2[0][0][1] = 1;
//        System.out.println(b.size());
//        System.out.println(map.get('a'));
//
//        int length = map2.length;
//
//        ArrayDeque<Integer> queue = new ArrayDeque<>();
//        queue.add(1);
//        queue.add(2);
//        queue.add(3);
//        queue.add(4);
//        queue.offer(5);
//        System.out.println(queue.poll());
//        System.out.println(queue.pollLast());
//        System.out.println(queue.pollFirst());
//        char[][] map3=new char[1][1];
//        boolean b1 = map3[0][0] !='\0';
//
//        Executors.newCachedThreadPool();
//
//
//
//        String s1 = "assssassa";
//
//        String substring = s1.substring(2,6);
//        System.out.println(substring);
//        boolean a1 = s1.contains("substring");
//        StringBuilder s2=new StringBuilder();
//        s1.charAt(1);
//
//        StringBuilder append = s2.append(s1.charAt(1));
//
//        List<Integer> q=new ArrayList<Integer>();
//        q.add(1);
//        q.add(2);
//        List w=new ArrayList(q);
//        q.remove(1);
//        System.out.println("len"+w.size());
//
//        PriorityQueue<Object> objects1 = new PriorityQueue<>();
//        objects1.offer(111);
//        objects1.peek();
//
//
//        Integer[] result=new Integer[q.size()];
//        q.toArray(result);
//
//
//        Test test = new Test();
//        int i = test.numDecodings("9371597631128776948387197132267188677349946742344217846154932859125134924241649584251978418763151253");
//        System.out.println(i);
    }

    public int numDecodings(String s) {
        int result;
        if (s.equals("")) {
            return 1;
        }
        if (s == null || s.substring(0, 1).equals("0")) {
            return 0;
        }

        if (s.length() >= 2 && 0 < Integer.valueOf(s.substring(0, 2)) && Integer.valueOf(s.substring(0, 2)) <= 26) {
            return numDecodings(s.substring(2)) + numDecodings(s.substring(1));
        }

        return numDecodings(s.substring(1));
    }

    public static int numTrees(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int[] nums = new int[n + 1];
        nums[0] = 1;
        nums[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                nums[i] = nums[i] + nums[j] * nums[i - 1 - j];
            }
        }
        return nums[n];


    }
}
//
//class A implements Runnable{
//    public int a =6;
//    @Override
//    public void run() {
//
//        System.out.print(a);
//    }
//}
//
//class B extends Thread{
//    @Override
//    public void run() {
//        this.getThreadGroup();
//    }
//}