package com.example.demo.models;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "Persons")
public class PersonModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(unique = false, nullable = false)
    private String name;

    @Column(unique = false, nullable = false)
    private String lastName;

    @Column(unique = false, nullable = true)
    private String motherLastName;

    @Column(unique = false, nullable = false)
    private Integer identifications;

    @OneToMany(mappedBy = "person")
    private List<InvoiceModel> invoices = new ArrayList<>();

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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMotherLastName() {
        return motherLastName;
    }

    public void setMotherLastName(String motherLastName) {
        this.motherLastName = motherLastName;
    }

    public Integer getIdentifications() {
        return identifications;
    }

    public void setIdentifications(Integer identifications) {
        this.identifications = identifications;
    }

}
