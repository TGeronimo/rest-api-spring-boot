package org.mathero.restapi.ui.model.response;

public class UserRest {
    private String name;
    private String surname;
    private String email;
    private String userId;

    public UserRest() {
    }

    public UserRest(String name, String surname, String email, String userId) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
