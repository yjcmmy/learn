package gc;

public class CountGc {
    public Object instance;
    public static void main(String args[]){
        CountGc o1=new CountGc();
        CountGc o2=new CountGc();
        //循环引用
        o1.instance=o2;
        o2.instance=o1;
        o1=null;
        o2=null;
        System.gc();
        
    }
}
