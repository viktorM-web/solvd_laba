package com.solvd.post.entity.enam;

import com.solvd.post.customInterface.Indexed;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

@Getter
@ToString
@AllArgsConstructor
public enum Service implements Indexed<Integer> {

    DELIVERY(1, "delivery", 10.05, 40.5f),
    EXPRESS_DELIVERY(2, "express delivery", 20.10, 50.7f),
    VIP_DELIVERY(3, "vip delivery", 30.63, 65.5f),
    TRACK(4, " track package", 0.0, 0.0f);

    private static final Logger log = LoggerFactory.getLogger(Service.class);

    private Integer id;
    private String name;
    private Double cost;
    private Float speed;

    public static Service getServiceById(Integer id) {
        return Arrays.stream(Service.values()).filter(service -> service.getId().equals(id))
                .findFirst().orElseGet(null);
    }

    public static void options() {
        Arrays.stream(Service.values()).iterator()
                .forEachRemaining(ser -> log.info(ser.getName() + " id " + ser.getId()));
    }

    @Override
    public Integer getIndex() {
        return id;
    }
}
