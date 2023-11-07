package com.solvd.post.entity;

import com.solvd.post.customInterface.Countable;
import com.solvd.post.customInterface.Sendable;
import com.solvd.post.entity.enam.Service;
import com.solvd.post.entity.util.Counter;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

@Getter
@Setter
@ToString(exclude = {"neighboringBranches", "toSendPackages", "camePackages"})
public class Department implements Countable<Integer> {

    private static final PostalChain POSTAL_CHAIN = PostalChain.getINSTANCE();

    private static Integer counter = 1;

    private Integer id;
    private Address address;
    private Contact contact;
    private Map<Department, Integer> neighboringBranches = new HashMap<>();
    private Double indexService;
    private List<Employee> employees;
    private Map<Integer, Sendable> toSendPackages = new HashMap<>();
    private Map<Integer, Letter> camePackages = new HashMap<>();

    public Department(Address address,
                      Contact contact,
                      Double indexService,
                      List<Employee> employees) {
        this.id = counter++;
        this.address = address;
        this.contact = contact;
        this.indexService = indexService;
        this.employees = employees;
    }

    public void useService(Scanner scanner) {
        answerEmployee();

        int indexService = scanner.nextInt();
        Service selectedService = Service.getServiceById(indexService);

        if (selectedService.equals(Service.TRACK)) {
            System.out.println("enter id your package");
            int id = scanner.nextInt();
            Letter letter = POSTAL_CHAIN.getLetter(id);
            System.out.println(letter == null ? "your package not find" : letter.getInfo());

        } else {
            System.out.println("Where do you want send? Choose department id");

            availableBranches();

            Department toDepartment = getDepartmentById(scanner.nextInt());

            Integer distance = neighboringBranches.get(toDepartment);

            scanner.nextLine();

            System.out.println("Enter info for sender");
            Consumer sender = Consumer.build(scanner, this);

            System.out.println("Enter info for recipient");
            Consumer recipient = Consumer.build(scanner, toDepartment);

            System.out.println("What do you want to send? \n if letter press 1 \n if package press 2");
            int type = scanner.nextInt();

            if (type == 1) {
                Letter letter = Counter.countLetter(sender, recipient, selectedService, distance, this);

                if (sendPackage(letter)) {
                    System.out.println("you send " + letter);
                } else {
                    System.out.println("your letter not send");
                }
            } else if (type == 2) {
                Package packag = Counter.countPackage(scanner, sender, recipient, selectedService, distance, this);

                if (sendPackage(packag)) {
                    System.out.println("you send " + packag);
                } else {
                    System.out.println("your package not send");
                }
            } else {
                System.out.println("Something went wrong");
            }
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

    private boolean sendPackage(Letter letter) {

        toSendPackages.put(letter.getId(), letter);

        return toSendPackages.containsValue(letter) && POSTAL_CHAIN.addPackage(letter);
    }

    @Override
    public Integer nextIndex() {
        return counter + 1;
    }

    @Override
    public Integer getIndex() {
        return id;
    }
}
