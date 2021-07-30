package com.github.sithumonline.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Person {
    private int id;
    private String name;
    private String nic;
    private String gender;
    private String address;
    private String employmentStats;

    public Person(int id, String name, String nic, String gender, String address, String employmentStats) {
        this.id = id;
        this.name = name;
        this.nic = nic;
        this.gender = gender;
        this.address = address;
        this.employmentStats = employmentStats;
    }

    public Person(String name, String nic, String gender, String address, String employmentStats) {
        this.name = name;
        this.nic = nic;
        this.gender = gender;
        this.address = address;
        this.employmentStats = employmentStats;
    }

    public Person() {

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
    @Column(name = "nic")
    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    @Basic
    @Column(name = "gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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
    @Column(name = "employmentStats")
    public String getEmploymentStats() {
        return employmentStats;
    }

    public void setEmploymentStats(String employmentStats) {
        this.employmentStats = employmentStats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) && Objects.equals(name, person.name) && Objects.equals(nic, person.nic) && Objects.equals(gender, person.gender) && Objects.equals(address, person.address) && Objects.equals(employmentStats, person.employmentStats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, nic, gender, address, employmentStats);
    }
}
