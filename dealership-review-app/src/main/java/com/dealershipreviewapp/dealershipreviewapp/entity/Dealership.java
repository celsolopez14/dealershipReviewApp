package com.dealershipreviewapp.dealershipreviewapp.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
@Entity
@Table(name = "dealerships")
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class Dealership {
    @Id
    @Column(name = "id")
    @NonNull
    private Integer id;

    @NonNull
    @Column(name = "city")
    private String city;

    @NonNull
    @Column(name = "state")
    private String state;

    @NonNull
    @Column(name = "st")
    private String st;

    @NonNull
    @Column(name = "address")
    private String address;

    @NonNull
    @Column(name = "zip")
    private String zip;


    @Column(name = "lat")
    @JsonProperty("lat")
    @NonNull
    private Double lat;

    @Column(name = "long")
    @JsonProperty("long")
    @NonNull
    private Double mylong;

    @NonNull
    @Column(name = "short_name")
    private String short_name;

    @NonNull
    @Column(name = "full_name")
    private String full_name;

    @JsonIgnore
    @OneToMany(mappedBy = "dealership", cascade = CascadeType.ALL)
    private Set<Review> reviews;
}
