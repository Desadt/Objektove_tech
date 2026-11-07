package com.example.bankovyucet;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

public class Employee implements Runnable {
    private static final AtomicInteger NEXT_ID = new AtomicInteger(1);
    private final int id;
    private final BankAccount account;
    private final boolean deposit;
    private final long amountCents;
    private final Consumer<TransactionResult> onFinished;

    public Employee(
            BankAccount account,
            boolean deposit,
            long amountCents,
            Consumer<TransactionResult> onFinished
    ){
        this.id = NEXT_ID.getAndIncrement();
        this.account = account;
        this.deposit = deposit;
        this.amountCents = amountCents;
        this.onFinished = onFinished;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(150, 850));
            TransactionResult result = account.transact(id,deposit,amountCents);
            onFinished.accept(result);
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}
