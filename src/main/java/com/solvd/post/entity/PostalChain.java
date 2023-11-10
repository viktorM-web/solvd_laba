package com.solvd.post.entity;

import com.solvd.post.customException.ExceptionHandlerUtil;
import com.solvd.post.customInterface.Growing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public final class PostalChain implements Growing<Department> {

    public static final Logger log = LoggerFactory.getLogger(PostalChain.class);

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
        log.info("Hello, which branch would you like to contact? \n");
        options(getDepartments());
        log.info("Enter id needed branch");


        Integer idDepartment = ExceptionHandlerUtil.handleNotValidException(scanner);

        return getDepartment(idDepartment);
    }

    private void options(Collection<Department> departments) {
        for (Department dep : departments) {
            log.info("id " + dep.getId() + " city " + dep.getAddress());
        }
    }
}
