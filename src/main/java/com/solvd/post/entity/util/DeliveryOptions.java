package com.solvd.post.entity.util;

import com.solvd.post.customInterface.IPair;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliveryOptions implements IPair<Integer, Integer> {

    private Integer time;
    private Integer damage;

    public DeliveryOptions(Integer time, Integer damage) {
        this.time = time;
        this.damage = damage;
    }

    @Override
    public Integer getKey() {
        return time;
    }

    @Override
    public Integer getValue() {
        return damage;
    }
}
