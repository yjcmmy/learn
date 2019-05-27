package classLoader;
import sun.misc.Launcher;

public class ClassLoaderPath {
    public static void main(String args[]){
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));
        ClassLoader.getSystemClassLoader();

        System.out.println(ClassLoader.class.getClassLoader());
        
        System.out.println(Launcher.class.getClassLoader());

        //java -Djava.system.class.loader=classLoader.MyClassLoader classLoader.ClassLoaderPath
        //需要写一个构造方法
        //先要cd C:\Code\JVM\out\production\JVM
        System.out.println(System.getProperty("java.system.class.loader"));
    }
}
