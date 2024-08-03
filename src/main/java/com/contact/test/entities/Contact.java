package com.contact.test.entities;

import jakarta.persistence.*;
import org.hibernate.engine.spi.ManagedEntity;

import java.util.Date;

@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "column_Id")
    private int c_id;
    private String firstname;
    private String lastname;
    private String mb_no;
    private String email;
    private String address;
    private String work;
    private String relation;
    @Temporal(TemporalType.DATE)
    private Date dob;
    private String description;
    @JoinColumn(name = "user_Id")
    @ManyToOne
    private User user;

    public Contact() {
        super();
    }
    public Contact(int c_id, String firstname, String lastname, String mb_no, String email, String address, String work, String relation, Date dob, String description , User user) {
        this.c_id = c_id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.mb_no = mb_no;
        this.email = email;
        this.address = address;
        this.work = work;
        this.relation = relation;
        this.dob = dob;
        this.description = description;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMb_no() {
        return mb_no;
    }

    public void setMb_no(String mb_no) {
        this.mb_no = mb_no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "c_id=" + c_id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", mb_no=" + mb_no +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", work='" + work + '\'' +
                ", relation='" + relation + '\'' +
                ", dob=" + dob +
                ", description='" + description + '\'' +
                '}';
    }
}
