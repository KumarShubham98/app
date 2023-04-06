package com.blog.api.app.entity;


import javax.persistence.*;


@Table(name = "Users")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "Name")
    private String name;
    @Column(name = "PhoneNumber")
    private int contactnumber;
    @Column(name = "Address")
    private String address;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getContactnumber() {
        return contactnumber;
    }

    public void setContactnumber(int contactnumber) {
        this.contactnumber = contactnumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public User(long id, String name, int contactnumber, String address) {
        this.id = id;
        this.name = name;
        this.contactnumber = contactnumber;
        this.address = address;
    }


    public User() {
    }
}
