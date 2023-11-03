package com.solvd.post.entity;

import com.solvd.post.entity.enam.State;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Package extends Letter {

    private Double weight;
    private Double length;
    private Double width;
    private Double height;

    public Package(Consumer sender,
                   Consumer recipient,
                   Double cost,
                   Department location,
                   State state,
                   Integer damagePercent,
                   Double weight,
                   Double length,
                   Double width,
                   Double height) {
        super(sender, recipient, cost, location, state, damagePercent);
        this.weight = weight;
        this.length = length;
        this.width = width;
        this.height = height;
    }
}
