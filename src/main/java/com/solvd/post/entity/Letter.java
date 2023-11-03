package com.solvd.post.entity;

import com.solvd.post.entity.enam.State;
import lombok.Data;

@Data
public class Letter {

    private static Integer counter = 1;

    private Integer id;
    private Consumer sender;
    private Consumer recipient;
    private Double cost;
    private Department location;
    private State state;
    private Integer damagePercent;

    public Letter(Consumer sender,
                  Consumer recipient,
                  Double cost,
                  Department location,
                  State state,
                  Integer damagePercent) {
        this.sender = sender;
        this.recipient = recipient;
        this.cost = cost;
        this.location = location;
        this.state = state;
        this.damagePercent = damagePercent;
        id = counter++;
    }
}
