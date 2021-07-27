package com.github.sithumonline.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Societies {
    private int id;
    private String name;
    private String orientation;
    private String officeBearer;
    private int monthlyMembershipFee;
    private String ageGroup;

    public Societies(int id, String name, String orientation, String officeBearer, int monthlyMembershipFee, String ageGroup) {
        this.id = id;
        this.name = name;
        this.orientation = orientation;
        this.officeBearer = officeBearer;
        this.monthlyMembershipFee = monthlyMembershipFee;
        this.ageGroup = ageGroup;
    }

    public Societies(String name, String orientation, String officeBearer, int monthlyMembershipFee, String ageGroup) {
        this.name = name;
        this.orientation = orientation;
        this.officeBearer = officeBearer;
        this.monthlyMembershipFee = monthlyMembershipFee;
        this.ageGroup = ageGroup;
    }

    public Societies() {

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
    @Column(name = "orientation")
    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    @Basic
    @Column(name = "officeBearer")
    public String getOfficeBearer() {
        return officeBearer;
    }

    public void setOfficeBearer(String officeBearer) {
        this.officeBearer = officeBearer;
    }

    @Basic
    @Column(name = "monthlyMembershipFee")
    public int getMonthlyMembershipFee() {
        return monthlyMembershipFee;
    }

    public void setMonthlyMembershipFee(int monthlyMembershipFee) {
        this.monthlyMembershipFee = monthlyMembershipFee;
    }

    @Basic
    @Column(name = "ageGroup")
    public String getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Societies societies = (Societies) o;
        return monthlyMembershipFee == societies.monthlyMembershipFee && Objects.equals(id, societies.id) && Objects.equals(name, societies.name) && Objects.equals(orientation, societies.orientation) && Objects.equals(officeBearer, societies.officeBearer) && Objects.equals(ageGroup, societies.ageGroup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, orientation, officeBearer, monthlyMembershipFee, ageGroup);
    }
}
