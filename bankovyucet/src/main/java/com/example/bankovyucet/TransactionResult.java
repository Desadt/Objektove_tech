package com.example.bankovyucet;

public record TransactionResult(
        int employeeId,
        boolean deposit,
        long amountCents,
        boolean success,
        long balanceCents,
        String message
){}
