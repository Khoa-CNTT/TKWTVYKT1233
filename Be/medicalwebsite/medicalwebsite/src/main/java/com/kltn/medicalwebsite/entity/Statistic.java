package com.kltn.medicalwebsite.entity;


import jakarta.persistence.*;

@Entity
public class Statistic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @ManyToOne
    @JoinColumn(name = "id_review",referencedColumnName = "id")
    private Review review;


    @ManyToOne
    @JoinColumn(name = "id_client",referencedColumnName = "id")
    private Client client;


    @ManyToOne
    @JoinColumn(name = "id_payment",referencedColumnName = "id")
    private  Payment payment;


    public Statistic() {
    }

    public Statistic(Long id, Review review, Client client, Payment payment) {
        this.id = id;
        this.review = review;
        this.client = client;
        this.payment = payment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
