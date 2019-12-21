package org.fasttrackit.nationsmatch.transfer;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class SaveUserRequest {

    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotNull
    private Integer age;
    private String description;
    private String nationality;
    private String imageUrl;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "SaveUserRequest{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", description='" + description + '\'' +
                ", nationality='" + nationality + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
