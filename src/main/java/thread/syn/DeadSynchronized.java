package thread.syn;

import thread.testobject.SynObject1;
import thread.testobject.SynObject2;

import java.util.concurrent.TimeUnit;

/**
 * @author hao
 * Description  程序模拟死锁
 * @date 2020/2/7
 */
public class DeadSynchronized {

    private  void method1(SynObject1 o1,SynObject2 o2){
        synchronized (o1){
        System.out.println("method1 get o1");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (o2){
            System.out.println("method1 get o2");
        }
        }
    }
    private  void method2(SynObject1 o1,SynObject2 o2){
        synchronized (o2){
            System.out.println("method2 get o2");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o1){
                System.out.println("method2 get o1");
            }
        }
    }

    public static void main(String[] args) {
        DeadSynchronized deadSynchronized = new DeadSynchronized();
        SynObject1 synObject1 = new SynObject1("大房");
        SynObject2 synObject2 = new SynObject2("二房");
        new Thread(() -> deadSynchronized.method1(synObject1,synObject2)).start();
        new Thread(() -> deadSynchronized.method2(synObject1,synObject2)).start();
//        deadSynchronized.method1(synObject1,synObject2);
//        deadSynchronized.method2(synObject1,synObject2);
//        new Thread(() ->deadSynchronized.method1())
    }

}
