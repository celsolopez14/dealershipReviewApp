package com.dealershipreviewapp.dealershipreviewapp.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "reviews")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(name = "dealership_id", referencedColumnName = "id")
    private Dealership dealership;

    @Column(name = "review", nullable = false)
    private String review;

    @Column(name = "purchase", nullable = false)
    private boolean purchase;

    @Column(name = "purchase_date", nullable = false)
    private String purchase_date;

    @Column(name = "car_make", nullable = false)
    private String car_make;

    @Column(name = "car_model", nullable = false)
    private String car_model;

    @Column(name = "car_year", nullable = false)
    private int car_year;

    @Column(name = "created_at", nullable = false)
    private LocalDate createdAt = LocalDate.now();
    
}
