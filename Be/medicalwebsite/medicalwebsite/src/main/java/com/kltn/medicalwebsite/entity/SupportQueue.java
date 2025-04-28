package com.kltn.medicalwebsite.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class SupportQueue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "id_client",referencedColumnName = "id")
    private Client client;


    @ManyToOne
    @JoinColumn(name = "id_customersupport",referencedColumnName = "id")
    private  CustomerSupport customerSupport;

    @Column(columnDefinition = "text")
    private  String issueDescription;

    private  String status;

    @Column(columnDefinition = "text")
    private String resolve;

    private LocalDateTime createAt;

    public SupportQueue() {
    }

    public SupportQueue(Long id, Client client, CustomerSupport customerSupport, String issueDescription, String status, String resolve, LocalDateTime createAt) {
        this.id = id;
        this.client = client;
        this.customerSupport = customerSupport;
        this.issueDescription = issueDescription;
        this.status = status;
        this.resolve = resolve;
        this.createAt = createAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public CustomerSupport getCustomerSupport() {
        return customerSupport;
    }

    public void setCustomerSupport(CustomerSupport customerSupport) {
        this.customerSupport = customerSupport;
    }

    public String getIssueDescription() {
        return issueDescription;
    }

    public void setIssueDescription(String issueDescription) {
        this.issueDescription = issueDescription;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResolve() {
        return resolve;
    }

    public void setResolve(String resolve) {
        this.resolve = resolve;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }
}
