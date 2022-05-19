package edu.umb.cs681.hw13;

import java.util.concurrent.atomic.AtomicBoolean;

public class DepositRunnable implements Runnable {

    private ThreadSafeBankAccount2 account = null;
    public AtomicBoolean done = new AtomicBoolean(false);

    public DepositRunnable(ThreadSafeBankAccount2 account) {
        this.account = account;
    }

    public void setDone(){
        done.set(true);
    }

    @Override
    public void run() {

        while(true){
            if(done.get()){
                break;
            }

            account.deposit(300);
            System.out.println("$300 deposited.\nBalance:"+account.getBalance());

            try{
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                continue;
            }
        }

    }

}
