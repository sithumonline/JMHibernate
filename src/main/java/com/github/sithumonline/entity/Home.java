package com.github.sithumonline.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Home {
    private int id;
    private int number;
    private String constructionsStatus;
    private int areaOfTheHouse;
    private String address;
    private String electricityAndWaterSupply;

    public Home(int id, int number, String constructionsStatus, int areaOfTheHouse, String address, String electricityAndWaterSupply) {
        this.id = id;
        this.number = number;
        this.constructionsStatus = constructionsStatus;
        this.areaOfTheHouse = areaOfTheHouse;
        this.address = address;
        this.electricityAndWaterSupply = electricityAndWaterSupply;
    }

    public Home(int number, String constructionsStatus, int areaOfTheHouse, String address, String electricityAndWaterSupply) {
        this.number = number;
        this.constructionsStatus = constructionsStatus;
        this.areaOfTheHouse = areaOfTheHouse;
        this.address = address;
        this.electricityAndWaterSupply = electricityAndWaterSupply;
    }

    public Home() {

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
    @Column(name = "number")
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Basic
    @Column(name = "constructionsStatus")
    public String getConstructionsStatus() {
        return constructionsStatus;
    }

    public void setConstructionsStatus(String constructionsStatus) {
        this.constructionsStatus = constructionsStatus;
    }

    @Basic
    @Column(name = "areaOfTheHouse")
    public int getAreaOfTheHouse() {
        return areaOfTheHouse;
    }

    public void setAreaOfTheHouse(int areaOfTheHouse) {
        this.areaOfTheHouse = areaOfTheHouse;
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
    @Column(name = "electricityAndWaterSupply")
    public String getElectricityAndWaterSupply() {
        return electricityAndWaterSupply;
    }

    public void setElectricityAndWaterSupply(String electricityAndWaterSupply) {
        this.electricityAndWaterSupply = electricityAndWaterSupply;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Home home = (Home) o;
        return number == home.number && areaOfTheHouse == home.areaOfTheHouse && Objects.equals(id, home.id) && Objects.equals(constructionsStatus, home.constructionsStatus) && Objects.equals(address, home.address) && Objects.equals(electricityAndWaterSupply, home.electricityAndWaterSupply);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, constructionsStatus, areaOfTheHouse, address, electricityAndWaterSupply);
    }
}
