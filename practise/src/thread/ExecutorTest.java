package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class ExecutorTest {

    public static void main(String[] args){
        ExecutorService executorService = Executors.newCachedThreadPool(new ThreadFactory1());
        executorService.execute(new Thread1());
        new Thread(new Thread1()).start();
    }

}

class Thread1 implements Runnable{
    @Override
    public void run() {
        for(int i=0;i<=10000;i++){
            System.out.println(i+" ");
        }
    }
}

class ThreadFactory1 implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        System.out.println("factory run");
        return new Thread(r);
    }
}