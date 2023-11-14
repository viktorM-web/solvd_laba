package com.solvd.post.entity;

import com.solvd.post.customColection.MyLinkedList;
import com.solvd.post.customException.ExceptionHandlerUtil;
import com.solvd.post.customInterface.Countable;
import com.solvd.post.customInterface.Sendable;
import com.solvd.post.entity.enam.Service;
import com.solvd.post.entity.util.Counter;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

@Getter
@Setter
@ToString(exclude = {"neighboringBranches", "toSendPackages", "camePackages"})
public class Department implements Countable<Integer> {

    private static final PostalChain POSTAL_CHAIN = PostalChain.getINSTANCE();
    public static final Logger log = LoggerFactory.getLogger(Department.class);

    private static Integer counter = 1;

    private Integer id;
    private Address address;
    private Contact contact;
    private Map<Department, Integer> neighboringBranches = new HashMap<>();
    private Double indexService;
    private ArrayList<Employee> employees;
    private MyLinkedList<Sendable> toSendPackages = new MyLinkedList<>();
    private Set<Letter> camePackages = new HashSet<>();

    public Department(Address address,
                      Contact contact,
                      Double indexService,
                      List<Employee> employees) {
        this.id = counter++;
        this.address = address;
        this.contact = contact;
        this.indexService = indexService;
        this.employees = new ArrayList<>(employees);
    }

    public void useService(Scanner scanner) {
        answerEmployee();

        int indexService = ExceptionHandlerUtil.handleNotValidException(scanner);

        Service selectedService = Service.getServiceById(indexService);

        while (selectedService == null) {
            log.info("not correct index");
            indexService = ExceptionHandlerUtil.handleNotValidException(scanner);
            selectedService = Service.getServiceById(indexService);

        }

        if (selectedService.equals(Service.TRACK)) {
            log.info("enter id your package");

            Integer id = ExceptionHandlerUtil.handleNotValidException(scanner);

            Letter letter = POSTAL_CHAIN.getLetter(id);
            log.info(letter == null ? "your package not find" : letter.getInfo());

        } else {
            log.info("Where do you want send? Choose department id");

            availableBranches();

            Integer id = ExceptionHandlerUtil.handleNotValidException(scanner);

            Department toDepartment = getDepartmentById(id);

            while (toDepartment == null) {
                log.info("not correct index");
                id = ExceptionHandlerUtil.handleNotValidException(scanner);
                toDepartment = getDepartmentById(id);
            }

            Integer distance = neighboringBranches.get(toDepartment);

            scanner.nextLine();

            log.info("Enter info for sender");
            Consumer sender = Consumer.build(scanner, this);

            log.info("Enter info for recipient");
            Consumer recipient = Consumer.build(scanner, toDepartment);

            log.info("What do you want to send? \n if letter press 1 \n if package press 2");

            int type = ExceptionHandlerUtil.handleNotValidException(scanner);

            if (type == 1) {
                Letter letter = Counter.countLetter(sender, recipient, selectedService, distance, this);

                if (sendPackage(letter)) {
                    log.info("you send " + letter);
                } else {
                    log.info("your letter not send");
                }
            } else if (type == 2) {
                Package packag = Counter.countPackage(scanner, sender, recipient, selectedService, distance, this);

                if (sendPackage(packag)) {
                    log.info("you send " + packag);
                } else {
                    log.info("your package not send");
                }
            } else {
                log.info("Something went wrong");
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
        log.info(String.format("I'm %s %s. What service do you need?%n", employee.getPost(), employee.getName()));
        Service.options();
        log.info("Enter id needed service");
    }

    private Employee getEmployee() {
        Random random = new Random();
        return employees.get(random.nextInt(employees.size()));
    }

    private void availableBranches() {
        Set<Department> departments = getNeighboringBranches().keySet();
        for (Department dep : departments) {
            log.info(String.format("id %s sity %s", dep.getId(), dep.getAddress().getCity()));
        }
    }

    private boolean sendPackage(Letter letter) {

        toSendPackages.add(letter);

        return toSendPackages.contains(letter) && POSTAL_CHAIN.addPackage(letter);
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
