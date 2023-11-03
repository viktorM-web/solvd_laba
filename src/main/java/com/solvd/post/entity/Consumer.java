package com.solvd.post.entity;

import java.util.Scanner;

public class Consumer extends PersonalData {

    private Address address;

    public Consumer(String name, String surname, String passport, Address address) {
        super(name, surname, passport);
        this.address = address;
    }

    @Override
    protected String getFullInformation() {
        return getName() + " " + getSurname() + " " + getPassport() + " " + address;
    }

    public static Consumer build(Scanner scanner, Department department) {
        System.out.println("Enter name for sender");
        String name = scanner.nextLine();
        System.out.println("Enter surname for sender");
        String surname = scanner.nextLine();
        System.out.println("Enter passport for sender");
        String passport = scanner.nextLine();
        return new Consumer(name, surname, passport, department.getAddress());
    }
}
