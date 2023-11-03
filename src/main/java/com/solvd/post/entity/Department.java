package com.solvd.post.entity;

import com.solvd.post.entity.enam.Service;
import com.solvd.post.entity.util.Counter;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class Department {

    private Integer id;
    private Address address;
    private Contact contact;
    private Map<Department, Integer> neighboringBranches = new HashMap<>();
    private Double indexService;
    private List<Employee> employees;

    public Department(Integer id,
                      Address address,
                      Contact contact,
                      Double indexService,
                      List<Employee> employees) {
        this.id = id;
        this.address = address;
        this.contact = contact;
        this.indexService = indexService;
        this.employees = employees;
    }

    public void useService(Scanner scanner) {
        answerEmployee();

        int indexService = scanner.nextInt();
        Service selectedService = Service.getServiceById(indexService);

        System.out.println("Where do you want send? Choose department id");

        availableBranches();

        Department toDepartment = getDepartmentById(scanner.nextInt());

        Integer distance = neighboringBranches.get(toDepartment);

        scanner.nextLine();

        Consumer sender = Consumer.build(scanner, this);

        Consumer recipient = Consumer.build(scanner, toDepartment);

        System.out.println("What do you want to send? \n if letter press 1 \n if package press 2");
        int type = scanner.nextInt();

        if (type == 1) {
            Letter letter = Counter.countLetter(sender, recipient, selectedService, distance, this);
            System.out.println("you send " + letter);
        } else if (type == 2) {
            Package packag = Counter.countPackage(scanner, sender, recipient, selectedService, distance, this);
            System.out.println("you send " + packag);
        } else {
            System.out.println("Something went wrong");
        }
    }

    private Department getDepartmentById(Integer id) {
        for (Department dep : neighboringBranches.keySet()) {
            if (dep.getId() == id) {
                return dep;
            }
        }
        return null;
    }

    private void answerEmployee() {
        Employee employee = getEmployee();
        System.out.println("I'm " + employee.getPost() + " " + employee.getName() +
                ". What service do you need? ");
        Service.options();
        System.out.println("Enter id needed service");
    }

    private Employee getEmployee() {
        Random random = new Random();
        return employees.get(random.nextInt(employees.size()));
    }

    private void availableBranches() {
        Set<Department> departments = getNeighboringBranches().keySet();
        for (Department dep : departments) {
            System.out.println("id " + dep.getId() + " sity " + dep.getAddress().getCity());
        }
    }
}
