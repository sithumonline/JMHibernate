package com.github.sithumonline.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Shops {
    private int id;
    private String name;
    private String registrationNumber;
    private String ownersName;
    private String address;
    private String type;

    public Shops(int id, String name, String registrationNumber, String ownersName, String address, String type) {
        this.id = id;
        this.name = name;
        this.registrationNumber = registrationNumber;
        this.ownersName = ownersName;
        this.address = address;
        this.type = type;
    }

    public Shops(String name, String registrationNumber, String ownersName, String address, String type) {
        this.name = name;
        this.registrationNumber = registrationNumber;
        this.ownersName = ownersName;
        this.address = address;
        this.type = type;
    }

    public Shops() {

    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "registrationNumber")
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    @Basic
    @Column(name = "ownersName")
    public String getOwnersName() {
        return ownersName;
    }

    public void setOwnersName(String ownersName) {
        this.ownersName = ownersName;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shops shops = (Shops) o;
        return Objects.equals(id, shops.id) && Objects.equals(name, shops.name) && Objects.equals(registrationNumber, shops.registrationNumber) && Objects.equals(ownersName, shops.ownersName) && Objects.equals(address, shops.address) && Objects.equals(type, shops.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, registrationNumber, ownersName, address, type);
    }
}
