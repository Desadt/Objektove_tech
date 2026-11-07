package com.example.bankovyucet;

public class BankAccount {
    private long balanceCents;

    public BankAccount(long startingCents){
        if(startingCents < 0) throw new IllegalArgumentException("startingCents cannot be less then 0");
        balanceCents = startingCents;
    }

    public synchronized TransactionResult transact(
            int employeeId,
            boolean deposit,
            long amountCents
    ) {
        if (amountCents <= 0) return new TransactionResult(employeeId, deposit, amountCents,
                    false, balanceCents,
                    "Ammount needs to be greater then 0"
            );
        if (!deposit && amountCents > balanceCents) return new TransactionResult(employeeId, false, amountCents,
                    false, balanceCents,
                    "Not enought on the account"
            );
        balanceCents += deposit ? amountCents : -amountCents;
        return new TransactionResult(
                employeeId, deposit, amountCents,
                true,  balanceCents, "OK"
        );
    }

    public synchronized long getBalanceCents(){
        return balanceCents;
    }
}
