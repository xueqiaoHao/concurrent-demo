package thread.syn;

import java.util.function.Consumer;

/**
 * @author hao
 * Description
 * @date 2020/2/7
 */
public class Account {
    String name;
    Integer balance;

    public synchronized void set(String name,Integer balance) {
        this.name = name;
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        this.balance = balance;
    }
    public synchronized Integer getBalance(){
        return this.balance;
    }

    public static void main(String[] args) {
        Account account = new Account();
        Consumer<Object> consumer = new Consumer<Object>() {
            @Override
            public void accept(Object o) {
                System.out.println(o);
            }
        };
        new Thread(() -> account.set("张三",100)).start();
        consumer.accept("余额"+account.getBalance());
        System.out.println(account.getBalance());
        consumer.accept("余额"+account.getBalance());
//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(account.getBalance());
//        try {
//            TimeUnit.SECONDS.sleep(2);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(account.getBalance());
    }
}
