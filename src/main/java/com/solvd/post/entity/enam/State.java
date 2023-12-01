package com.solvd.post.entity.enam;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public enum State {

    LOST("Lost", "Package was lost on the way"),
    DELIVERED("Delivered", "Package is waiting at the pick up point"),
    IN_TRANSIT("In transit", "Package at delivery service");

    private String state;
    private String message;

    State(String state, String message) {
        this.state = state;
        this.message = message;
    }

    public String displayMassage(){
        log.info(message);
        return message;
    }

    public static State[] displayAvailableStates(){
        Arrays.stream(State.values()).forEach(v->log.info(v.name()));
        return State.values();
    }
}
