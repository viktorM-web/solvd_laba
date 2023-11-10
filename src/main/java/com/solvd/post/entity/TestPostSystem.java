package com.solvd.post.entity;

import com.solvd.post.entity.util.Creator;
import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class TestPostSystem {

    static {
        System.err.println("Program started");
    }

    public static void main(String[] args) {

        PostalChain postalChain = Creator.createPostSystem();
        try (Scanner scanner = new Scanner(System.in)) {

            while (true) {
                Department department = postalChain.contactWithDepartment(scanner);
                try {

                    department.useService(scanner);

                } catch (NullPointerException e) {

                    e.printStackTrace();
                    log.info("not correct index");
                }
            }
        }
    }
}

