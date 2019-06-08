package com.maktab25.homework11.tamrin2.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "phone_number")
@Getter
@Setter
@NoArgsConstructor
public class PhoneNumber implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tel_number")
    private String telNumber;

    @Column(name = "mobile_number")
    private String mobileNumber;

    public PhoneNumber(String telNumber, String mobileNumber) {
        this.telNumber = telNumber;
        this.mobileNumber = mobileNumber;
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "telNumber='" + telNumber + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                '}';
    }
}