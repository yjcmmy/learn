package pingDuoDuo;

import com.sun.xml.internal.ws.wsdl.parser.MemberSubmissionAddressingWSDLParserExtension;
import sun.security.krb5.internal.tools.Klist;

import javax.naming.InterruptedNamingException;
import javax.print.attribute.standard.NumberOfInterveningJobs;
import javax.xml.ws.soap.Addressing;
import java.util.*;
import java.util.function.Predicate;

public class Solution3 {
    static int flag=0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Map<Integer, HashSet<Integer>> map = new HashMap<>();
        int[][] all = new int[m][2];
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if (map.get(a) == null) {
                HashSet<Integer> set1 = new HashSet<Integer>();
                map.put(a, set1);
            }
            map.get(a).add(b);
            if (map.get(b) == null) {
                HashSet<Integer> set2 = new HashSet<Integer>();
                map.put(b, set2);
            }
            map.get(b).add(a);
            all[i][0]=a;
            all[i][1]=b;
        }
//        HashSet<Integer> set3=new HashSet<>();
//        for(Integer i = 0;i<m;i++){
//            set3.addAll(map.get(all[i][0]));
//            set3.retainAll(map.get(all[i][1]));
//            if(set3.size()>=1){
//                System.out.println(0);
//                return;
//            }
//        }

        Set<Integer> l1=new HashSet<>();
        Set<Integer> l2=new HashSet<>();
        for(Integer i = 0;i<m;i++){

        }

        System.out.println(1);







    }

    //
    static void fun(int[][] all,int n , Set<Integer> l1,Set<Integer> l2){
        if(n== all.length){
            flag=1;
        }




    }





//    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        int n=scanner.nextInt();
//        long[] a=new long[n+1];
//        long[] b=new long[n+1];
//
//         for(int i=1;i<=n;i++){
//             int cur=i;
//             a[i]=a[i-1];
//             while(cur%5==0){
//                  a[i]++;
//                  cur=cur/5;
//             }
//             b[i]=a[i]+b[i-1];
//         }
//        System.out.println(b[n]);
//
//
//    }


//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        Node head = new Node(0);
//        Node cur = head;
//
//        String s=scanner.nextLine();
//        String[] s1=s.split(" ");
//        int k  =scanner.nextInt();
//
//        for (String s2:s1) {
//
//            Node node = new Node(Integer.valueOf(s2));
//            cur.next = node;
//            cur = cur.next;
//        }
//        cur = head.next;
//        int flag=0;
//        Node pre=head;
//        while(judge(cur,k)){
//            cur=reverse(cur,k);
//            pre.next=cur;
//            if(flag==0){
//                head=cur;
//            }
//            for(int i=0;i<k-1;i++){
//                cur=cur.next;
//            }
//            pre=cur;
//            cur=cur.next;
//
//
//            flag++ ;
//        }
//
//        while(head!=null){
//            System.out.print(head.value+" ");
//            head=head.next;
//        }
//
//
//    }
//
//    static Node reverse(Node head, int k) {
//        int n = k;
//        Node pre = new Node(0);
//        Node cur = head;
//        Node next = cur.next;
//        for (int i = 0; i < k; i++) {
//            cur.next = pre;
//            pre=cur;
//            cur = next;
//            if(next!=null){
//                next = next.next;
//            }
//        }
//        head.next=cur;
//        return pre;
//
//    }
//
//    static boolean judge(Node head, int k) {
//        while (head != null) {
//            k--;
//            if (k == 0) {
//                return true;
//            }
//            head = head.next;
//        }
//        return false;
//    }

}

//class Node {
//    int value;
//    Node next;
//
//    public Node(int value) {
//        this.value = value;
//    }
//
//
//}
