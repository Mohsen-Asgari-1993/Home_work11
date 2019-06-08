package com.maktab25.homework11.tamrin2.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employee")
@Setter
@Getter
@NoArgsConstructor
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "em_code")
    private String emCode;

    @Column(name = "salary")
    private Long salary;

    @OneToMany(mappedBy = "employee", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Address> addresses;

    public Employee(String emCode, Long salary, List<Address> addreses) {
        this.emCode = emCode;
        this.salary = salary;
        this.addresses = addreses;
    }

    public void addAddress(Address address) {
        if (addresses == null)
            addresses = new ArrayList<>();
        addresses.add(address);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", emCode='" + emCode + '\'' +
                ", salary=" + salary +
                ", address=" + addresses +
                '}' + "\n";
    }
}