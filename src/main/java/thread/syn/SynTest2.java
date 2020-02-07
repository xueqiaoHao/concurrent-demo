package thread.syn;

/**
 * @author hao
 * Description synchronize是可重入的锁
 * @date 2020/2/7
 */
public class SynTest2 {
    private synchronized void m1(){
        System.out.println("m1");
        m2();
    }

    private synchronized void m2(){
        System.out.println("m2");
    }

    public static void main(String[] args) {
        SynTest2 synTest2 = new SynTest2();
//        new Thread((()->synTest2.m1())).start();
        synTest2.m1();
    }
}
