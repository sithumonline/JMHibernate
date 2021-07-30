package com.github.sithumonline.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Family {
    private int id;
    private String surname;
    private int numberOfMembers;
    private int totalIncome;
    private String religion;
    private String headOfFamily;

    public Family(int id, String surname, int numberOfMembers, int totalIncome, String religion, String headOfFamily) {
        this.id = id;
        this.surname = surname;
        this.numberOfMembers = numberOfMembers;
        this.totalIncome = totalIncome;
        this.religion = religion;
        this.headOfFamily = headOfFamily;
    }

    public Family(String surname, int numberOfMembers, int totalIncome, String religion, String headOfFamily) {
        this.surname = surname;
        this.numberOfMembers = numberOfMembers;
        this.totalIncome = totalIncome;
        this.religion = religion;
        this.headOfFamily = headOfFamily;
    }

    public Family() {

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
    @Column(name = "surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "numberOfMembers")
    public int getNumberOfMembers() {
        return numberOfMembers;
    }

    public void setNumberOfMembers(int numberOfMembers) {
        this.numberOfMembers = numberOfMembers;
    }

    @Basic
    @Column(name = "totalIncome")
    public int getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(int totalIncome) {
        this.totalIncome = totalIncome;
    }

    @Basic
    @Column(name = "religion")
    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    @Basic
    @Column(name = "headOfFamily")
    public String getHeadOfFamily() {
        return headOfFamily;
    }

    public void setHeadOfFamily(String headOfFamily) {
        this.headOfFamily = headOfFamily;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return numberOfMembers == family.numberOfMembers && totalIncome == family.totalIncome && Objects.equals(id, family.id) && Objects.equals(surname, family.surname) && Objects.equals(religion, family.religion) && Objects.equals(headOfFamily, family.headOfFamily);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, surname, numberOfMembers, totalIncome, religion, headOfFamily);
    }
}
