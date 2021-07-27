package com.github.sithumonline.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class CropCultivation {
    private int id;
    private String cropType;
    private int numberOfAcres;
    private int numberOfCultivators;
    private int estimatedFertilizer;
    private int receivedFertilize;

    public CropCultivation(int id, String cropType, int numberOfAcres, int numberOfCultivators, int estimatedFertilizer, int receivedFertilize) {
        this.id = id;
        this.cropType = cropType;
        this.numberOfAcres = numberOfAcres;
        this.numberOfCultivators = numberOfCultivators;
        this.estimatedFertilizer = estimatedFertilizer;
        this.receivedFertilize = receivedFertilize;
    }

    public CropCultivation(String cropType, int numberOfAcres, int numberOfCultivators, int estimatedFertilizer, int receivedFertilize) {
        this.cropType = cropType;
        this.numberOfAcres = numberOfAcres;
        this.numberOfCultivators = numberOfCultivators;
        this.estimatedFertilizer = estimatedFertilizer;
        this.receivedFertilize = receivedFertilize;
    }

    public CropCultivation() {

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
    @Column(name = "cropType")
    public String getCropType() {
        return cropType;
    }

    public void setCropType(String cropType) {
        this.cropType = cropType;
    }

    @Basic
    @Column(name = "numberOfAcres")
    public int getNumberOfAcres() {
        return numberOfAcres;
    }

    public void setNumberOfAcres(int numberOfAcres) {
        this.numberOfAcres = numberOfAcres;
    }

    @Basic
    @Column(name = "numberOfCultivators")
    public int getNumberOfCultivators() {
        return numberOfCultivators;
    }

    public void setNumberOfCultivators(int numberOfCultivators) {
        this.numberOfCultivators = numberOfCultivators;
    }

    @Basic
    @Column(name = "estimatedFertilizer")
    public int getEstimatedFertilizer() {
        return estimatedFertilizer;
    }

    public void setEstimatedFertilizer(int estimatedFertilizer) {
        this.estimatedFertilizer = estimatedFertilizer;
    }

    @Basic
    @Column(name = "receivedFertilize")
    public int getReceivedFertilize() {
        return receivedFertilize;
    }

    public void setReceivedFertilize(int receivedFertilize) {
        this.receivedFertilize = receivedFertilize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CropCultivation that = (CropCultivation) o;
        return numberOfAcres == that.numberOfAcres && numberOfCultivators == that.numberOfCultivators && estimatedFertilizer == that.estimatedFertilizer && receivedFertilize == that.receivedFertilize && Objects.equals(id, that.id) && Objects.equals(cropType, that.cropType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cropType, numberOfAcres, numberOfCultivators, estimatedFertilizer, receivedFertilize);
    }
}
