package com.solvd.post.entity;

import com.solvd.post.entity.enam.Post;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Employee extends PersonalData {

    private Post post;

    public Employee(String name, String surname, String passport, Post post) {
        super(name, surname, passport);
        this.post = post;
    }

    @Override
    protected String getFullInformation() {
        return getName() + " " + getSurname() + " " + getPassport() + " " + post;
    }
}
