package com.solvd.post.entity;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PostalChain {

    private Map<Integer, Department> departments = new HashMap<>();
    private Map<Integer, Letter> packages = new HashMap<>();

    public Collection<Department> getDepartments() {
        return departments.values();
    }

    public void addDepartment(Department department) {
        departments.put(department.getId(), department);
    }

    public Department getDepartment(Integer id) {
        return departments.get(id);
    }

    public Department contactWithDepartment(Scanner scanner) {
        System.out.println("Hello, which branch would you like to contact? \n");
        options(getDepartments());
        System.out.println("Enter id needed branch");

        return getDepartment(scanner.nextInt());
    }

    private void options(Collection<Department> departments) {
        for (Department dep : departments) {
            System.out.println("id " + dep.getId() + " city " + dep.getAddress());
        }
    }
}
