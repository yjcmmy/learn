package classLoader;

import java.sql.Driver;
import java.util.Iterator;
import java.util.ServiceLoader;

public class Spi {
    public static void main(String args[]){
//        Thread.currentThread().setContextClassLoader(Spi.class.getClassLoader().getParent());
        ServiceLoader<Driver> serviceLoader = ServiceLoader.load(Driver.class);
        Iterator<Driver> iterator = serviceLoader.iterator();
        while(iterator.hasNext()){
            Driver driver=iterator.next();
            System.out.println("driver:"+driver.getClass()+",Loader:"+driver.getClass().getClassLoader());
        }

        System.out.println("当前线程的上下文加载器:"+Thread.currentThread().getContextClassLoader());
        System.out.println("serviceLoader的加载器:"+ServiceLoader.class.getClassLoader());
        
        System.out.println("当前线程的上下文加载器hash:"+Thread.currentThread().getContextClassLoader().hashCode());
        System.out.println("Spi的加载器hash:"+Spi.class.getClassLoader().hashCode());
    }
}
