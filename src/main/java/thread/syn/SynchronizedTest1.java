package thread.syn;

/**
 * @author hao
 * Description
 * @date 2020/2/7
 */
public class SynchronizedTest1 {
    private synchronized void m1(){
        System.out.println(Thread.currentThread().getName()+ " m1 start");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" m1  end");
    }
    private void m2(){

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"  m2");
    }

    public static void main(String[] args) {
        SynchronizedTest1 synchronizedTest1 = new SynchronizedTest1();
        new Thread(()->synchronizedTest1.m1(),"t1").start();
        new Thread(()->synchronizedTest1.m2(),"t2").start();

        new Thread(synchronizedTest1::m1,"t1").start();
        new Thread(synchronizedTest1::m2,"t2").start();

    }
}
