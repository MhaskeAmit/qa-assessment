package com.questionpro.grocery.Items.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "User_info")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "emailId")
    private String emailId;
    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "grocery_id", cascade=CascadeType.ALL)
    private Grocery grocery;

    public User() {
    }

    public User(String name, String emailId, String address, Grocery groceries) {
        this.name = name;
        this.emailId = emailId;
        this.address = address;
        this.grocery = groceries;
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

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Grocery getGroceries() {
        return grocery;
    }

    public void setGroceries(Grocery groceries) {
        this.grocery = groceries;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", emailId='" + emailId + '\'' +
                ", address='" + address + '\'' +
                ", groceries=" + grocery +
                '}';
    }
}
