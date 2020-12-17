package com.example._packageChallenge;

public class Series {
    public static int nSum(int n) {
        return n * (n + 1) / 2;
    }

    public static int factorial(int n) {
        int result=0;
        if(n==0) {
            return 1;
        }
        return n*factorial(n - 1);
    }

    public static int fibonacci(int n) {
        if(n==1) {
            return 0;
        }
        else if(n==2) {
            return 1;
        }
        else {
            return fibonacci(n-2)+ fibonacci(n-1);
        }
    }
}
