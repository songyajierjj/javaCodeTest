package com.thread;

public class TurnTest {

    private int count = 0;
    private final Object lock = new Object();

    public static void main(String[] args) throws Exception{
        TurnTest test = new TurnTest();
        Thread a = new Thread(test.new TurningRunner(),"一");
        Thread b = new Thread(test.new TurningRunner(),"二");
        Thread c = new Thread(test.new TurningRunner(),"三");
        a.start();
        Thread.sleep(1);
        b.start();
        Thread.sleep(1);
        c.start();
    }

    class TurningRunner implements Runnable{
        @Override
        public void run(){
            while (count <= 100){
                synchronized (lock){
                    System.out.println(Thread.currentThread().getName() + ": " + count++);
                    lock.notifyAll();
                    try{
                        if(count <= 100){
                            lock.wait();
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
