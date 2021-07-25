package cn.itcast.thread.safe;

public class SaleWindow implements Runnable {

    private int id = 10;   //表示10张火车票   这是共享资源

    //卖10张火车票
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (id > 0) {
                System.out.println(Thread.currentThread().getName()
                        + "卖了编号为" + id + "的火车票");
                id--;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }
        }
    }
}
