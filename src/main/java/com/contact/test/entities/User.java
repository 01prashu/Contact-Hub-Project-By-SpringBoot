package com.contact.test.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_Id")
    private int id;
    @Column(name = "user_Name")
    private String name;

    @Column(name = "user_Column", unique = true)
    private String email;

    private String password;

    private String image;
    @Column(length = 500)
    private String about;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Contact> contacts;

    public User(int id, String name, String email, String password,  String imager, String about, List<Contact> contacts) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.image = imager;
        this.about = about;
        this.contacts = contacts;
    }

    public User() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String imager) {
        this.image = imager;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    @OneToMany(cascade =CascadeType.ALL)
    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' + '\'' +
                ", imager='" + image + '\'' +
                ", about='" + about + '\'' +
                ", contacts=" + contacts +
                '}';
    }
}
