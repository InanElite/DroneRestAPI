package com.restfulAPI.rest.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "drones_table")
public class Drone {

    @Id
    @Column(name = "drone_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "drone_serialNumber", nullable = false)
    private String serialNumber;

    @Column(name = "drone_model", nullable = false)
    private String model;

    @Column(name = "drone_weightLimit", nullable = false)
    private Integer weightLimit;

    @Column(name = "drone_batteryCapacity", nullable = false)
    private Integer batteryCapacity;

    @Column(name = "drone_state", nullable = false)
    private String state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getWeightLimit() {
        return weightLimit;
    }

    public void setWeightLimit(Integer weightLimit) {
        this.weightLimit = weightLimit;
    }

    public Integer getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(Integer batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Drone)) return false;
        Drone drone = (Drone) o;
        return Objects.equals(getId(), drone.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

}
