package edu.umb.cs681.hw13;

import java.util.concurrent.atomic.AtomicBoolean;

public class WithdrawRunnable implements Runnable{

    private ThreadSafeBankAccount2 account = null;
    public AtomicBoolean done = new AtomicBoolean(false);

    public WithdrawRunnable(ThreadSafeBankAccount2 account) {
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

            account.withdraw(100);
            System.out.println("$100 withdrawn.\nBalance:"+account.getBalance());

            try{
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                continue;
            }
        }

    }
}
