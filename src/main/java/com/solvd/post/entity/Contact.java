package com.solvd.post.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class Contact {

    private Set<Integer> phoneNumber;
    private Set<String> email;

}
