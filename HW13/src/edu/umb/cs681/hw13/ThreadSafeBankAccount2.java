package edu.umb.cs681.hw13;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeBankAccount2 {

    private ReentrantLock lock = new ReentrantLock();
    private Condition sufficientFundsCondition = lock.newCondition();
    private Condition belowUpperLimitFundsCondition = lock.newCondition();
    private double balance = 0;

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount){
        lock.lock();
        while(balance <= 0){
            try {
                sufficientFundsCondition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.balance -= amount;
        belowUpperLimitFundsCondition.signalAll();
        lock.unlock();
    }

    public void deposit(double amount){
        lock.lock();
        while(balance >= 300){
            try {
                belowUpperLimitFundsCondition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.balance += amount;
        sufficientFundsCondition.signalAll();
        lock.unlock();
    }

}
