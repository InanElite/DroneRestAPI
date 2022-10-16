package com.restfulAPI.rest.dto;

import javax.persistence.Column;
import java.util.Objects;

public class DroneDto {

    private Integer id;

    private String serialNumber;

    private String model;

    private Integer weightLimit;

    private Integer batteryCapacity;

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
        if (!(o instanceof DroneDto)) return false;
        DroneDto droneDto = (DroneDto) o;
        return Objects.equals(getId(), droneDto.getId()) && Objects.equals(getSerialNumber(), droneDto.getSerialNumber()) && Objects.equals(getModel(), droneDto.getModel()) && Objects.equals(getWeightLimit(), droneDto.getWeightLimit()) && Objects.equals(getBatteryCapacity(), droneDto.getBatteryCapacity()) && Objects.equals(getState(), droneDto.getState());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSerialNumber(), getModel(), getWeightLimit(), getBatteryCapacity(), getState());
    }

    @Override
    public String toString() {
        return "DroneDto{" +
                "id=" + id +
                ", serialNumber='" + serialNumber + '\'' +
                ", model='" + model + '\'' +
                ", weightLimit=" + weightLimit +
                ", batteryCapacity=" + batteryCapacity +
                ", state='" + state + '\'' +
                '}';
    }
}
