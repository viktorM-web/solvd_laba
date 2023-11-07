package com.solvd.post.entity;

import com.solvd.post.entity.util.Creator;

import java.util.Scanner;

public class TestPostSystem {

    static {
        System.err.println("Program started");
    }

    public static void main(String[] args) {

        PostalChain postalChain = Creator.createPostSystem();
        try (Scanner scanner = new Scanner(System.in)) {

            while (true) {
                Department department = postalChain.contactWithDepartment(scanner);

                if (department == null) {

                    System.out.println("not correct index");

                } else {

                    department.useService(scanner);

                }
            }
        }
    }
}

