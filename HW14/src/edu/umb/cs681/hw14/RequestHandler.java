package edu.umb.cs681.hw14;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class RequestHandler implements Runnable{

    private ReentrantLock lock = new ReentrantLock();
    private boolean flag = false;

    public void setFlag() {
        lock.lock();
        try {
            flag = true;
        }
        finally {
            lock.unlock();
        }
    }

    @Override
    public void run() {

        String[] files = {"AccessCounter.class", "RequestHandler.class", "a.html",
                "b.html", "c.html", "d.html"};
        AccessCounter instance = AccessCounter.getInstance();

        while (true) {
            lock.lock();
            try {
                if(flag) {
                    System.out.println("No Access");
                    break;
                }

                int index = new Random().nextInt(files.length);
                Path path = FileSystems.getDefault().getPath(".", files[index]);

                instance.increment(path);
                System.out.println(files[index] + "--- " + instance.getCount(path));
            }
            finally {
                lock.unlock();
            }

            try {
                Thread.sleep(1000);
            }
            catch(InterruptedException e) {
                System.out.println(e.toString());
                continue;
            }
        }

    }

    public static void main(String[] args) {

        for (int i=0; i<13; i++){

            RequestHandler r  = new RequestHandler();
            Thread t  = new Thread(r);
            t.start();

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            r.setFlag();
            t.interrupt();

            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
