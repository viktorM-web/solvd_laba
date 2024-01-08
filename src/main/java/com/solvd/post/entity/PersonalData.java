package com.solvd.post.entity;

import com.solvd.post.customInterface.Indexed;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class PersonalData implements Indexed<String> {

    private String name;
    private String surname;
    private String passport;

    protected abstract String getFullInformation();

    @Override
    public String getIndex() {
        return passport;
    }
}
