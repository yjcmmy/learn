package xieCheng;


import java.util.Scanner;

public class Main {

     //这个为0表示还有括号，为1表示没括号了
    public static int flag=0;

    static String resolve(String expr) {

        //这里是为了判断括号是不是匹配
        int count=0;
        for (int i = 0; i < expr.length(); i++) {
             if(expr.charAt(i)=='('){
                 count++;
             }
            if(expr.charAt(i)==')'){
                count--;
                if(count<0){
                    return "";
                }
            }

        }
        if(count!=0){
            return "";
        }




        while (flag==0){
            expr=getS(expr);

        }
        return expr;


    }

    //这个是每次从头遍历，碰到一堆括号就将括号内的反转，一直循环调用这个函数，直到没括号为止
    public static String getS(String s) {
        String b = "";
        int r = 0;
        int l = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                r = i;
            }
            if (s.charAt(i) == ')') {
                l = i;
                break;
            }
            if (i == s.length() - 1 && s.charAt(i) != ')') {
                flag = 1;
                return s;
            }
        }
        String c=new StringBuffer(s.substring(r+1,l)).reverse().toString();
        b = s.substring(0, r) + c+s.substring(l + 1);
        return b;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        String _expr;
        try {
            _expr = in.nextLine();
        } catch (Exception e) {
            _expr = null;
        }

        res = resolve(_expr);
        System.out.println(res);
    }
}
