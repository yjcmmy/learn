package classLoader;


import inner.Outter;

public class Test1 {
    public String name;


    public static int num=0;
    public Test1(){
         num++;
         name="test" +num;
    }

    static {
        System.out.println("初始化Test1");
    }

    @Override
    public String toString() {
        return "CountGc{" +
                "name='" + name + '\'' +
                '}';
    }
    public static void main(String args[]){
        int a= 115;
        String s = String.valueOf(a);
        a = Integer.parseInt(s.substring(0, 1));
        Outter outter=new Outter();
        System.out.println(a);
    }
}
