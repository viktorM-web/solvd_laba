package com.solvd.post.entity;

import com.solvd.post.customException.ExceptionHandlerUtil;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Getter
@Slf4j
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
        log.info("Enter name");
        String name = ExceptionHandlerUtil.handleNameValidException(scanner);
        log.info("Enter surname");
        String surname = ExceptionHandlerUtil.handleNameValidException(scanner);
        log.info("Enter passport");
        String passport = ExceptionHandlerUtil.handlePassportValidException(scanner);
        return new Consumer(name, surname, passport, department.getAddress());
    }
}
