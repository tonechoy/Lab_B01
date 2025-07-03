package com.fsse2506.lab_b01;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PersonData {
    private String firstName;
    private String lastName;
    private String hkid;

    public PersonData(String firstName, String lastName, String hkid) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.hkid = hkid;
    }

    @JsonProperty("first_name")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("first_name")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonProperty("last_name")
    public String getLastName() {
        return lastName;
    }

    @JsonProperty("last_name")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonProperty("hkid_number")
    public String getHkid() {
        return hkid;
    }

    @JsonProperty("hkid_number")
    public void setHkid(String hkid) {
        this.hkid = hkid;
    }



}
