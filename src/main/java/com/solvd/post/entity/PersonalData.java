package com.solvd.post.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class PersonalData {

    private String name;
    private String surname;
    private String passport;

    protected abstract String getFullInformation();
}
