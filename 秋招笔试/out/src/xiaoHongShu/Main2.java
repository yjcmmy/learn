package xiaoHongShu;

import com.sun.org.apache.bcel.internal.generic.I2B;

import java.util.*;

public class Main2 {
    public static int[][] next = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static Queue<List<Integer>> queue = new LinkedList<>();
    static int count;

    static int sa = 0;
    static int sb = 0;
    static int ea = 0;
    static int eb = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int n = Integer.valueOf(s);
        int[][] map = new int[n][n];
        int sa = 0;
        int sb = 0;
        int ea = 0;
        int eb = 0;
        for (int i = 0; i < n; i++) {
            s = scanner.nextLine();
            for (int j = 0; j < n; j++) {
                if (s.charAt(j) == '.') {
                    map[i][j] = 0;
                }
                if (s.charAt(j) == '#') {
                    map[i][j] = 1;
                }
                if (s.charAt(j) == 'S') {
                    sa = i;
                    sb = j;
                }
                if (s.charAt(j) == 'E') {
                    ea = i;
                    eb = j;
                }
            }
        }
        count = n * n;
        List<Integer> son1 = new ArrayList<>();
        son1.add(sa);
        son1.add(sb);
        queue.add(son1);

        while (queue.peek() != null) {
            count++;
            List<Integer> cur = queue.poll();
            int i = cur.get(0);
            int j = cur.get(1);
            while (i < 0) {
                i = i + n;
            }
            while (j < 0) {
                j = j + 0;
            }
            i = i % n;
            j = j % n;

            if (map[i][j] == 1) {
                continue;
            }

            map[i][j] = 1;
            if (i == ea && j == eb) {
                break;
            }

            for (int[] nexta : next) {
                int q = i + nexta[0];
                int w = j + nexta[1];
                List<Integer> son = new ArrayList<>();
                son.add(q);
                son.add(w);
                queue.add(son);
            }
        }
        count=(count-1)/4+1 ;
        System.out.println(count);


    }

}
