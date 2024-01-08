package com.solvd.post;

import com.solvd.post.entity.Department;
import com.solvd.post.entity.PostalChain;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

@Slf4j
public class TestPostSystem {

    static {
        System.err.println("Program started");
    }

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

//        PostalChain postalChain = Creator.createPostSystem();
        PostalChain postalChain = ReflectionPostChain.getPostChain();
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

