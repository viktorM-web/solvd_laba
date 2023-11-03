package com.solvd.post.entity.util;

import com.solvd.post.entity.Consumer;
import com.solvd.post.entity.Department;
import com.solvd.post.entity.Letter;
import com.solvd.post.entity.Package;
import com.solvd.post.entity.enam.Service;
import com.solvd.post.entity.enam.State;
import lombok.experimental.UtilityClass;

import java.util.Random;
import java.util.Scanner;

@UtilityClass
public class Counter {

    private static final Random RANDOM = new Random();

    public static Letter countLetter(Consumer sender,
                                     Consumer recipient,
                                     Service service,
                                     Integer distance,
                                     Department department) {

        double cost = distance / 100.0 * service.getCost();

        System.out.println("Cost of letter will be " + cost);

        Integer damage = countDamage(50, 110, service);

        State state = damage > 97 ? State.LOST : State.IN_TRANSIT;
        System.out.println("letter can be damaged on " + damage + " percent");

        return new Letter(sender, recipient, cost, department, state, damage);
    }

    public static Package countPackage(Scanner scanner,
                                       Consumer sender,
                                       Consumer recipient,
                                       Service service,
                                       Integer distance,
                                       Department department) {

        System.out.println("Enter weight in kg");
        Double weight = scanner.nextDouble();
        System.out.println("Enter length in centimeters");
        Double length = scanner.nextDouble();
        System.out.println("Enter width in centimeters");
        Double width = scanner.nextDouble();
        System.out.println("Enter height in centimeters");
        Double height = scanner.nextDouble();

        double cost = distance / 100.0 * service.getCost() * weight + length * weight * width / 1000;

        System.out.println("cost of package will be " + cost);

        Integer damage = countDamage(50, 110, service);

        System.out.println("package can be damaged on " + damage + " percent");
        State state = damage > 97 ? State.LOST : State.IN_TRANSIT;

        return new Package(sender, recipient, cost, department, state, damage, weight, length, width, height);
    }

    private static Integer countDamage(Integer avereg, Integer max, Service service) {
        return switch (service) {
            case DELIVERY -> RANDOM.nextInt(101);
            case VIP_DELIVERY -> 0;
            case EXPRESS_DELIVERY -> RANDOM.nextInt(50);
            default -> 0;
        };
    }
}
