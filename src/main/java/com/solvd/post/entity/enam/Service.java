package com.solvd.post.entity.enam;

import lombok.*;

@Getter
@ToString
@AllArgsConstructor
public enum Service {

    DELIVERY(1, "delivery", 10.05),
    EXPRESS_DELIVERY(2, "express delivery", 20.10),
    VIP_DELIVERY(3, "vip delivery", 30.63);

    private Integer id;
    private String name;
    private Double cost;

    public static Service getServiceById(Integer id){
        for (Service service : Service.values()) {
            if (service.getId() == id) {
                return service;
            }
        }
        return null;
    }

    public static void options() {
        for (Service ser:Service.values()) {
            System.out.println("id " + ser.getId() + " name " + ser.getName());
        }
    }
}
