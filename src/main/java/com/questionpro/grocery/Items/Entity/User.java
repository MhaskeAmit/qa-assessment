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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int user_id;
    @Column(name = "name")
    private String name;
    @Column(name = "emailId")
    private String emailId;
    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "user", cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private List<Grocery> grocery;

    public User() {
    }

    public User(String name, String emailId, String address, List<Grocery> groceries) {
        this.name = name;
        this.emailId = emailId;
        this.address = address;

    }

    public int getId() {
        return user_id;
    }

    public void setId(int id) {
        this.user_id = id;
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

    public List<Grocery> getGroceries() {
        return grocery;
    }

    public void setGroceries(List<Grocery> groceries) {
        this.grocery = groceries;
    }

    public void add(Grocery tempGrocery){

        if(grocery == null){
            grocery = new ArrayList<>();
        }
        grocery.add(tempGrocery);
        tempGrocery.setUser(this);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + user_id +
                ", name='" + name + '\'' +
                ", emailId='" + emailId + '\'' +
                ", address='" + address + '\'' +
                ", groceries=" + grocery +
                '}';
    }
}
