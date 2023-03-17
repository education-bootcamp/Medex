package com.developersstack.medex.dto;

import com.developersstack.medex.enums.GenderType;

public class DoctorDto {
    private String firstName;
    private String lastName;
    private String nic;
    private String contact;
    private String email;
    private String specializations;
    private String address;
    private GenderType gender;

    public DoctorDto() {
    }

    public DoctorDto(String firstName, String lastName, String nic, String contact, String email, String specializations, String address, GenderType gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nic = nic;
        this.contact = contact;
        this.email = email;
        this.specializations = specializations;
        this.address = address;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSpecializations() {
        return specializations;
    }

    public void setSpecializations(String specializations) {
        this.specializations = specializations;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public GenderType getGender() {
        return gender;
    }

    public void setGender(GenderType gender) {
        this.gender = gender;
    }
}
