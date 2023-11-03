package com.solvd.post.entity;

import com.solvd.post.entity.util.Creator;

import java.util.Scanner;

public class TestPostSystem {

    public static void main(String[] args) {

        PostalChain postalChain = Creator.createPostSystem();
        try (Scanner scanner = new Scanner(System.in)) {

            Department department = postalChain.contactWithDepartment(scanner);

            if (department == null) {

                System.out.println("not correct index");

            } else {

                department.useService(scanner);

            }
        }
    }
}

