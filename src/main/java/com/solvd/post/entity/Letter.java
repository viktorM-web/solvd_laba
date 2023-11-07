package com.solvd.post.entity;

import com.solvd.post.customInterface.Countable;
import com.solvd.post.customInterface.Sendable;
import com.solvd.post.entity.enam.State;
import com.solvd.post.entity.util.DeliveryOptions;
import lombok.Data;

@Data
public class Letter implements Sendable, Countable<Integer> {

    private static Integer counter = 1;

    private Integer id;
    private Consumer sender;
    private Consumer recipient;
    private Double cost;
    private Department location;
    private State state;
    private Integer damagePercent;
    private Integer timeOnDelivery;

    public Letter(Consumer sender,
                  Consumer recipient,
                  Double cost,
                  Department location,
                  State state,
                  Integer damagePercent,
                  Integer timeOnDelivery) {
        this.sender = sender;
        this.recipient = recipient;
        this.cost = cost;
        this.location = location;
        this.state = state;
        this.damagePercent = damagePercent;
        this.timeOnDelivery = timeOnDelivery;
        id = counter++;
    }

    public Letter(Consumer sender,
                  Consumer recipient,
                  Double cost,
                  Department location,
                  State state,
                  DeliveryOptions deliveryOptions) {
        this.sender = sender;
        this.recipient = recipient;
        this.cost = cost;
        this.location = location;
        this.state = state;
        this.damagePercent = deliveryOptions.getDamage();
        this.timeOnDelivery = deliveryOptions.getTime();
        id = counter++;
    }

    public final String getInfo() {
        return getClass().getTypeName() + " placed in " + location.getAddress() + " state " + state;
    }

    @Override
    public Address getDestination() {
        return recipient.getAddress();
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
