package com.solvd.post.enam;

import java.util.Arrays;

public enum Post {

    OFFICE_WORKER("office worker", 1200.59),
    DELIVERYMAN("deliveryman", 1350.55),
    MANAGER("manager", 1550.55),
    DIRECTOR("director", 1953.78);

    private String post;
    private Double salary;

    Post(String post, Double salary) {
        this.salary = salary;
        this.post = post;
    }

    public Double getSalary() {
        return salary;
    }

    public boolean salaryBiggerAverage() {
        return salary > Arrays.stream(Post.values()).count() / Post.values().length;
    }
}
