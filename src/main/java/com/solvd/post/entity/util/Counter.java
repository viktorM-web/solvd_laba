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
    private static final Integer AVERAGE_SPEED = 60;
    private static final Double INDEX_DISTANCE = 100.0;
    private static final Double INDEX_VOLUME = 1000.0;
    private static final Integer INDEX_LOSING = 97;
    private static final Integer MAX_DAMAGE = 101;
    private static final Integer AVERAGE_DAMAGE = 50;
    private static final Integer MIN_DAMAGE = 0;

    public static Letter countLetter(Consumer sender,
                                     Consumer recipient,
                                     Service service,
                                     Integer distance,
                                     Department department) {

        double cost = distance / INDEX_DISTANCE * service.getCost();

        System.out.println("Cost of letter will be " + cost);

        DeliveryOptions deliveryOptions = count(service, distance);

        State state = deliveryOptions.getDamage() > INDEX_LOSING ? State.LOST : State.IN_TRANSIT;
        System.out.println("letter can be damaged on " + deliveryOptions.getDamage() + " percent");

        return new Letter(sender, recipient, cost, department, state, deliveryOptions);
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

        Integer time = distance / AVERAGE_SPEED;

        double cost = distance / INDEX_DISTANCE * service.getCost() * weight + length * weight * width / INDEX_VOLUME;

        System.out.println("cost of package will be " + cost);

        DeliveryOptions deliveryOptions = count(service, distance);

        System.out.println("package can be damaged on " + deliveryOptions.getDamage() + " percent");
        State state = deliveryOptions.getDamage() > INDEX_LOSING ? State.LOST : State.IN_TRANSIT;

        return new Package(sender, recipient, cost, department, state, deliveryOptions, weight, length, width, height);
    }

    private static DeliveryOptions count(Integer average, Integer max, Service service, Integer distance) {
        return switch (service) {
            case DELIVERY -> new DeliveryOptions(Math.round(distance / service.getSpeed()), RANDOM.nextInt(max));
            case EXPRESS_DELIVERY -> new DeliveryOptions(Math.round(distance / service.getSpeed()), RANDOM.nextInt(average));
            case VIP_DELIVERY -> new DeliveryOptions(Math.round(distance / service.getSpeed()), MIN_DAMAGE);
            default -> null;
        };
    }

    private static DeliveryOptions count(Integer max, Service service, Integer distance) {
        return count(max / 2, max, service, distance);
    }

    private static DeliveryOptions count(Service service, Integer distance) {
        return count(AVERAGE_DAMAGE, MAX_DAMAGE, service, distance);
    }
}