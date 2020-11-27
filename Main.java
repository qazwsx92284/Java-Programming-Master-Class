package com.company;

import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    private static BankAccount ba = new BankAccount();
//
//    private static VipCustomer v1 = new VipCustomer();
//    private static VipCustomer v2 = new VipCustomer("second",200);
//    private static VipCustomer v3 = new VipCustomer("tim",300,"Tim@email.com");

    public static void main(String[] args) {
//        System.out.println(v1.getCreditLimit());
//        System.out.println(v1.getEmailAddress());
//        System.out.println(v1.getName());
//
//        System.out.println(v2.getCreditLimit());
//        System.out.println(v2.getEmailAddress());
//        System.out.println(v2.getName());
//
//        System.out.println(v3.getCreditLimit());
//        System.out.println(v3.getEmailAddress());
//        System.out.println(v3.getName());
//

//        System.out.println("--------------------------");
//        ba.setAccountNumber("12345");
//        ba.setBalance(1505.35);
//        ba.setCustomerName("Jordan");
//        ba.setEmail("aa2012375");
//        ba.setPhoneNumber("2019934123");
//
//        System.out.println(ba.getAccountNumber());
//        System.out.println(ba.getBalance());
//        System.out.println(ba.getCustomerName());
//        System.out.println(ba.getEmail());
//        System.out.println(ba.getPhoneNumber());
//        System.out.println("-----------------------------------");
        System.out.println("Press 1. Deposit 2. Withdraw  3.Quit");

        boolean flag = true;


        while(flag) {
            int action = sc.nextInt();
            sc.nextLine();
            switch (action) {
                case 1:
                    System.out.println("Enter amount");
                    double amountDeposit = sc.nextDouble();
                    sc.nextLine();
                    ba.deposit(amountDeposit);
                    System.out.println("Press options 1. Deposit 2. Withdraw 3.Quit");
                    break;
                case 2:
                    System.out.println("Enter amount");
                    double amountWithdraw = sc.nextDouble();
                    sc.nextLine();
                    ba.withdraw(amountWithdraw);
                    System.out.println("Press options 1. Deposit 2. Withdraw 3.Quit");
                    break;
                case 3:
                    flag = false;
            }
        }

//        ba.deposit(200);
//        ba.withdraw(10000.34);

    }
}
