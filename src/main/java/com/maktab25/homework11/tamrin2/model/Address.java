package com.maktab25.homework11.tamrin2.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "address")
@Setter
@Getter
@NoArgsConstructor
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "postal_address")
    private String postalAddress;

    @Column(name = "city")
    private String city;

    @ManyToOne
    @JoinColumn(name = "emp_id")
    private Employee employee;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PhoneNumber> numbers;

    public Address(String postalCode, String postalAddress, String city, List<PhoneNumber> numbers) {
        this.postalCode = postalCode;
        this.postalAddress = postalAddress;
        this.city = city;
        this.numbers = numbers;
    }

    public void addNumbers(PhoneNumber phoneNumber) {
        if (numbers == null)
            numbers = new ArrayList<>();
        numbers.add(phoneNumber);
    }

    @Override
    public String toString() {
        return "Address{" +
                "postalCode='" + postalCode + '\'' +
                ", postalAddress='" + postalAddress + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
