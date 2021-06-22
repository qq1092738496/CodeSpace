/**
 * @description:
 * @author: Andy
 * @time: 2021/6/12 23:37
 */

public class TestThread extends Thread{
    @Override
    public synchronized void start() {
        for (int i = 0; i < 10; i++) {
            System.out.println("start方法"+i);
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("run方法"+i);
        }
    }

    public static void main(String[] args) {

        TestThread testThread = new TestThread();
        testThread.start();

        for (int i = 0; i < 10000; i++) {
            System.out.println("mian函数"+i);
        }
    }
}
