package com.rzs.concurrent;

public class CalculatorPrimes implements Runnable {

    @Override
    public void run() {

        long current = 1l;
        long max = 20000l;
        long numPrimes = 0l;

        System.out.printf("Thread '%s': START\n", Thread.currentThread().getName());

        while (current <= max) {
            if(isPrime(current)) {
                numPrimes ++;
            }
            current++;
        }

        System.out.printf("Thread '%s': END. Number of Primes: %d\n",
                Thread.currentThread().getName(), numPrimes);
    }

    private boolean isPrime(long num) {

        if(num <= 2) {
            return true;
        }

        for (long i = 2; i < num; i++) {
            if((num % i) == 0) {
                return false;
            }
        }
        return true;
    }
}
