package com.solvd.post.entity;

import com.solvd.post.customInterface.Growing;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public final class PostalChain implements Growing<Department> {

    private static final PostalChain INSTANCE = new PostalChain();

    private Map<Integer, Department> departments = new HashMap<>();
    private Map<Integer, Letter> packages = new HashMap<>();

    private PostalChain() {
    }

    public static PostalChain getINSTANCE() {
        return INSTANCE;
    }

    public Collection<Department> getDepartments() {
        return departments.values();
    }

    public boolean add(Department department) {
        departments.put(department.getId(), department);
        return departments.containsValue(department);
    }

    public Letter getLetter(Integer id) {
        return packages.get(id);
    }

    public boolean addPackage(Letter letter) {
        packages.put(letter.getId(), letter);
        return packages.containsValue(letter);
    }

    public boolean deletePackage(Letter letter) {
        Letter remove = packages.remove(letter.getId());
        return remove != null;
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
