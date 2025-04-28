package com.kltn.medicalwebsite.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class CustomerSupport {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(columnDefinition = "varchar(120)")
    private  String name;

    @Column(columnDefinition = "varchar(15)")
    private  String phone;

    @Column(columnDefinition = "varchar(120)")
    private String address;


    @Column(columnDefinition = "varchar(50)")
    private  String password;

    @OneToMany(mappedBy = "customerSupport",cascade = CascadeType.REMOVE)
    private List<New> news;

    @OneToMany(mappedBy = "customerSupport",cascade = CascadeType.REMOVE)
    private List<SupportQueue> supportQueues;

    public CustomerSupport() {
    }

    public CustomerSupport(Long id, String name, String phone, String address, String password) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
