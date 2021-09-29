package com.example.testTask2.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    private Date dateBirth;
    @Column(unique = true, nullable = false)
    private String login;
    @Column(unique = true, nullable = false)
    private String password;
    private String aboutMySelf;
    private String addressResidence;

    public User() {
    }

    public User(Long id, String firstName, String lastName, Date dateBirth, String login, String password, String aboutMySelf, String addressResidence) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateBirth = dateBirth;
        this.login = login;
        this.password = password;
        this.aboutMySelf = aboutMySelf;
        this.addressResidence = addressResidence;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAboutMySelf() {
        return aboutMySelf;
    }

    public void setAboutMySelf(String aboutMySelf) {
        this.aboutMySelf = aboutMySelf;
    }

    public String getAddressResidence() {
        return addressResidence;
    }

    public void setAddressResidence(String addressResidence) {
        this.addressResidence = addressResidence;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateBirth=" + dateBirth +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", aboutMySelf='" + aboutMySelf + '\'' +
                ", addressResidence='" + addressResidence + '\'' +
                '}';
    }
}
