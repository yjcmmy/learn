package classLoader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class MyClassLoader extends ClassLoader{
    private String classLoaderName;
    private final String fileExtension=".class";
    private String path;

    public void setPath(String path) {
        this.path = path;
    }

    public MyClassLoader(ClassLoader parent, String classLoaderName){
        super(parent);
        this.classLoaderName=classLoaderName;
    }

    public MyClassLoader(String classLoaderName){
        super();
        this.classLoaderName=classLoaderName;
    }

    public MyClassLoader(ClassLoader parent){
        super(parent);
    }
    

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] date=this.loadClassDate(name);
        return this.defineClass(name,date,0,date.length) ;
    }

    private byte[] loadClassDate(String name){
       InputStream inputStream=null;
       ByteArrayOutputStream byteArrayOutputStream=null;
       byte[] date=null;

       System.out.println("通过MyClassLoader进行加载: "+classLoaderName);
       
        try {
            name= name.replace(".", "/");
            inputStream=new FileInputStream(new File(this.path+name+this.fileExtension));
            byteArrayOutputStream=new ByteArrayOutputStream();
            int ch;
            while((ch=inputStream.read())!=-1){
                byteArrayOutputStream.write(ch);
            }
            date=byteArrayOutputStream.toByteArray();
            
        }  catch (Exception e){
              e.printStackTrace();
        } finally {
            try {
                inputStream.close();
                byteArrayOutputStream.close();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return date;
   }

   public static void main(String args[]){
        ClassLoader myClassLoader=new MyClassLoader("定义类加载器1");
       loadTest1(myClassLoader);

       ClassLoader myClassLoader2=new MyClassLoader("定义类加载器2");
       loadTest1(myClassLoader2);

       ClassLoader myClassLoader3=new MyClassLoader(myClassLoader,"定义类加载器3");
       loadTest1(myClassLoader3);
   }

    public static void loadTest1(ClassLoader myClassLoader) {
        ((MyClassLoader) myClassLoader).setPath("C:\\code\\JVM\\MyClass\\");
        try {
            Class clazz = myClassLoader.loadClass("classLoader.Test1");
            System.out.println("加载完成:" + clazz.hashCode());
            Object test1 = clazz.newInstance();
            System.out.println(test1.toString());
            Object test2 = clazz.newInstance();
            System.out.println(test2.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
