package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyProxy{

    public static void main(String args[]){
        //这样可以把动态生成的代理类的字节码保存到com
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");

        Student yjc=new Student("yjc");
        Person proxy = (Person)Proxy.newProxyInstance(Person.class.getClassLoader(), new Class[]{Person.class}, new MyInvocationHandler(yjc));
        //和上面那个共用的一个代理类com/sun/proxy/$Proxy0.class
        Person proxy2 = (Person)Proxy.newProxyInstance(Person.class.getClassLoader(), new Class[]{Person.class}, new MyInvocationHandler2(yjc));
        //又生成了一个代理类com/sun/proxy/$Proxy1.class
        Person2 proxy3 = (Person2)Proxy.newProxyInstance(Person.class.getClassLoader(), new Class[]{Person2.class}, new MyInvocationHandler(yjc));
        proxy.giveMoney();
        proxy2.giveMoney();
        //class com.sun.proxy.$Proxy0
        System.out.println(proxy.getClass());
        //class java.lang.reflect.Proxy
        System.out.println(proxy.getClass().getSuperclass());
    }
}

class MyInvocationHandler implements InvocationHandler{
    Object object;

    MyInvocationHandler( Object object) {
        this.object=object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("动态代理1执行");
        method.invoke(object,args);
        return null;
    }
}
class MyInvocationHandler2 implements InvocationHandler{
    Object object;

    MyInvocationHandler2( Object object) {
        this.object=object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("动态代理2执行");
        method.invoke(object,args);
        return null;
    }
}