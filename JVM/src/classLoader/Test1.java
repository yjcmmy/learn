package classLoader;


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
        return "Test1{" +
                "name='" + name + '\'' +
                '}';
    }
}
